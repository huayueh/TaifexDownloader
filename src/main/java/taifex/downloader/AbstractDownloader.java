package taifex.downloader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.ssl.SSLContexts;
import org.apache.log4j.Logger;
import taifex.storage.Storage;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public abstract class AbstractDownloader implements Downloader {
    private static final Logger logger = Logger.getLogger(AbstractDownloader.class);
    private final Storage storage;
    private HttpClient httpClient;
    protected String datePattern = "yyyy/MM/dd";
    protected String name;
    protected String firstLine;
    protected Calendar calStart;
    protected Calendar calEnd;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected LocalDate fetchStart;
    protected LocalDate fetchEnd;
    protected Calendar oneMonCal;
    protected URL url;
    private Downloader dwner = this;

    public AbstractDownloader(URL url, Storage storage) {
        this.storage = storage;
        this.url = url;
        this.calStart = Calendar.getInstance();
        this.calEnd = Calendar.getInstance();
        this.httpClient = createClient();
    }

    private HttpClient createClient() {
        try {
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial((chain, authType) -> true).build();

            SSLConnectionSocketFactory sslConnectionSocketFactory =
                    new SSLConnectionSocketFactory(sslContext, new String[]
                            {"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}, null,
                            NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient client = HttpClients.custom()
                    .setSSLSocketFactory(sslConnectionSocketFactory)
                    .setRedirectStrategy(new LaxRedirectStrategy())
                    .build();
            return client;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public final void setStart(int sY, int sM, int sD) {
        this.startDate = LocalDate.of(sY, sM, sD);
        this.fetchStart = this.startDate;
        this.fetchEnd = this.startDate;
        this.calStart.set(sY, sM, sD);
    }

    @Override
    public final void setEnd(int eY, int eM, int eD) {
        this.endDate = LocalDate.of(eY, eM, eD);
        this.calEnd.set(eY, eM, eD);
    }

    @Override
    public void download() {
        if (httpClient == null)
            throw new IllegalStateException("Null HttpClient");

        while (fetchEnd.isBefore(endDate)) {
            InputStream is = null;
            HttpPost httpMsg = new HttpPost(getParams());

            try {
                httpMsg.setEntity(new UrlEncodedFormEntity(postPayload()));
                HttpResponse response = httpClient.execute(httpMsg);

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    is = entity.getContent();
                }

                if (is != null && storage.save(is, this)) {
                    setFetched();
                }
            } catch (IOException ex) {
                logger.error("", ex);
            }
        }
        logger.info(getName() + " update finish!");
    }

    @Override
    public void update() {
        Date date = storage.getLastDate(this.dwner);
        if (date == null) {
            logger.error(this.getName() + "is empty to update!!!");
            return;
        }
        calStart.setTime(date);
        calStart.add(Calendar.DATE, 1);
        download();
    }

    protected String getFetchStart() {
        return fetchStart.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    protected String getFetchEnd() {
        this.fetchEnd = fetchStart.with(lastDayOfMonth());
        return fetchEnd.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    @Override
    public LocalDateTime getCurrentTime() {
        return fetchEnd.atTime(LocalTime.MAX);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFirstLine() {
        return firstLine;
    }

    protected abstract String getParams();

    protected abstract List<NameValuePair> postPayload();

    protected void setFetched() {
        fetchStart = fetchEnd.plusDays(1);
    }

}
