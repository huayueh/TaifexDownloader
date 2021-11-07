package taifex.downloader;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
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
public class TwseDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(TwseDwner.class);

    public TwseDwner(URL url, Storage storage) {
        super(url, storage);
        name = "TWSE_HIS";
        firstLine = "日期,開盤指數,最高指數,最低指數,收盤指數" + IOUtils.LINE_SEPARATOR;
        requestMethod = HttpGet.METHOD_NAME;
        append = true;
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = fetchStart.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        URIBuilder builder = new URIBuilder().setPath(ret).
                addParameter("response", "json").
                addParameter("date", sDate);
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
        fetchStart = fetchEnd.plusMonths(1);
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

        try {
            JSONArray data = rep.getJSONArray("data");
            IntStream.range(0, data.length()).forEach(idx -> {
                JSONArray e = data.getJSONArray(idx);
                String date = e.getString(0);
                String open = e.getString(1);
                String high = e.getString(2);
                String low = e.getString(3);
                String close = e.getString(4);

                String[] d = StringUtils.split(date, "/");
                date = this.fetchStart.getYear() + d[1] + d[2];
                open = StringUtils.remove(open, ",");
                high = StringUtils.remove(high, ",");
                low = StringUtils.remove(low, ",");
                close = StringUtils.remove(close, ",");

                logger.debug("{},{},{},{},{},{},{}", date, open, high, low, close);
                lines.add(String.format("%s,%s,%s,%s,%s", date, open, high, low, close));
            });
        } catch (JSONException e) {
            if (!e.getMessage().contains("not found")){
                throw e;
            }
        }
        storage.save(lines, this);

        return true;
    }

    @Override
    public Object rowToPojo(String line) throws ParseException {
        return null;
    }
}
