package taifex.downloader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import taifex.storage.Storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public abstract class AbstractDownloader extends Thread implements Downloader {
    private static final Logger logger = Logger.getLogger(AbstractDownloader.class);
    private final Storage storage;
    private HttpClient httpClient = HttpClients.createDefault();
    protected String datePattern = "yyyy/MM/dd";
    protected String table;
    protected String firstLine;
    protected Calendar calStart;
    protected Calendar calEnd;
    protected Calendar oneMonCal;
    protected URL url;
    protected String props;
    protected boolean bPost = true;
    private Downloader dwner = this;

    public AbstractDownloader(URL url, Storage storage) {
        this.storage = storage;
        this.url = url;
        this.calStart = Calendar.getInstance();
        this.calEnd = Calendar.getInstance();
    }

    @Override
    public void run() {
        while (calStart.getTimeInMillis() < calEnd.getTimeInMillis()) {
            InputStream is = null;
            HttpGet httpMsg = new HttpGet(getURL());

            try {
                HttpResponse response = httpClient.execute(httpMsg);
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    is = entity.getContent();
                }

                if (is != null && storage.save(is, this)){
                    setDownloadTime();
                }
            } catch (IOException ex) {
                logger.error("", ex);
            }
        }
        logger.info(getTableName() + " update finish!");
    }

    @Override
    public final void setStart(int sY, int sM, int sD) {
        this.calStart.set(sY, sM, sD);
    }

    @Override
    public final void setEnd(int eY, int eM, int eD) {
        this.calEnd.set(eY, eM, eD);
    }

    @Override
    public void download() {
        this.start();
    }

    @Override
    public void update() {
        Date date = storage.getLastDate(this.dwner);
        if(date == null){
            logger.error(this.getTableName() + "is empty to update!!!");
            return;
        }
        calStart.setTime(date);
        calStart.add(Calendar.DATE, 1);
        download();
    }

    protected String getStartDate() {
        int sYear = calStart.get(Calendar.YEAR);
        int sMonth = calStart.get(Calendar.MONTH);
        int sDate = calStart.get(Calendar.DATE);
        return sYear + "/" + (sMonth + 1) + "/" + sDate;
    }

    protected String getEndDate() {
        oneMonCal = getOneMon();
        int eYear = oneMonCal.get(Calendar.YEAR);
        int eMonth = oneMonCal.get(Calendar.MONTH);
        int eDate = oneMonCal.get(Calendar.DATE);
        return eYear + "/" + (eMonth + 1) + "/" + eDate;
    }

    private Calendar getOneMon() {
        Calendar cal = (Calendar) calStart.clone();
        cal.add(Calendar.DATE, 20);
        if (cal.getTimeInMillis() > Calendar.getInstance().getTimeInMillis()) {
            cal = Calendar.getInstance();
        }
        return cal;
    }

    @Override
    public String getTableName() {
        return table;
    }

    @Override
    public String getFirstLine() {
        return firstLine;
    }

    protected abstract String getURL();

    protected void setDownloadTime() {
        calStart.setTime(oneMonCal.getTime());
        calStart.add(Calendar.DATE, 1);
    }
    
}
