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
public class TwseInsDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(TwseInsDwner.class);

    public TwseInsDwner(URL url, Storage storage) {
        super(url, storage);
        name = "TWSE_INS";
        firstLine = "日期,單位,買進,賣出" + IOUtils.LINE_SEPARATOR;
        requestMethod = HttpGet.METHOD_NAME;
        append = true;
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = fetchStart.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        URIBuilder builder = new URIBuilder().setPath(ret).
                addParameter("response", "json").
                addParameter("dayDate", sDate).
                addParameter("weekDate", "").
                addParameter("monthDate", "").
                addParameter("type", "day");
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
            JSONArray data = rep.getJSONArray("data");
            IntStream.range(0, 6).forEach(idx -> {
                JSONArray e = data.getJSONArray(idx);
                String unit = e.getString(0);
                String buy = e.getString(1);
                String sell = e.getString(2);

                buy = StringUtils.remove(buy, ",");
                sell = StringUtils.remove(sell, ",");

                logger.debug("{},{},{},{}", date, unit, buy, sell);
                lines.add(String.format("%s,%s,%s,%s", date, unit, buy, sell));
            });
        } catch (JSONException e) {
            if (!e.getMessage().contains("not found")){
                throw e;
            }
        }
        lines.remove(lines.size()-1); //remove total
        storage.save(lines, this);

        return true;
    }

}
