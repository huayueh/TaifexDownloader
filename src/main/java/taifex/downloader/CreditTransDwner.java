package taifex.downloader;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.storage.Storage;

/**
 * @author Harvey
 */
public class CreditTransDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(CreditTransDwner.class);

    public CreditTransDwner(URL url, Storage storage) {
        super(url, storage);
        name = "CREDIT_TRANS";
        firstLine = "日期,單位,買進,賣出,現金(券)償還,前日餘額,今日餘額" + IOUtils.LINE_SEPARATOR;
        requestMethod = HttpGet.METHOD_NAME;
        append = true;
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = fetchStart.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        URIBuilder builder = new URIBuilder().setScheme(url.getProtocol()).
                setHost(url.getHost()).
                setPath(url.getPath()).
                addParameter("response", "json").
                addParameter("date", sDate).
                addParameter("selectType", "MS");
        try {
            ret = builder.build().toString();
        } catch (URISyntaxException e) {

        }

        return ret;
    }

    protected List<NameValuePair> postPayload() {
        return Collections.EMPTY_LIST;
    }

    protected void setFetched() {
        logger.info("{} fetched", fetchStart);
        fetchStart = fetchEnd.plusDays(1);
        fetchEnd = fetchStart;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.error("{}", e);
        }
    }

    @Override
    public boolean processResponse(InputStream is) {
        JSONObject rep;
        List<String> lines = new ArrayList<>();

        try {
            rep = new JSONObject(new JSONTokener(is));
        }finally {
            IOUtils.closeQuietly(is);
        }

        if (!"OK".equals(rep.getString("stat"))){
            logger.debug("{} don't have data", fetchStart);
            return true;
        }

        String date = rep.getString("date");
        try {
            JSONArray data = rep.getJSONArray("creditList");
            IntStream.range(0, 4).forEach(idx -> {
                JSONArray e = data.getJSONArray(idx);
                String unit = e.getString(0);
                String buy = e.getString(1);
                String sell = e.getString(2);
                String reimburse = e.getString(3);
                String yesterday = e.getString(4);
                String today = e.getString(5);

                buy = StringUtils.remove(buy, ",");
                sell = StringUtils.remove(sell, ",");
                reimburse = StringUtils.remove(reimburse, ",");
                yesterday = StringUtils.remove(yesterday, ",");
                today = StringUtils.remove(today, ",");

                logger.debug("{},{},{},{},{},{},{}", date, unit, buy, sell, reimburse, yesterday, today);
                lines.add(String.format("%s,%s,%s,%s,%s,%s,%s", date, unit, buy, sell, reimburse, yesterday, today));
            });
        } catch (JSONException e) {
            if (!e.getMessage().contains("not found")){
                throw e;
            }
        }
        storage.save(lines, this);

        return true;
    }

}
