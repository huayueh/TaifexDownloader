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
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
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
        name = "TWSE";
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

        if ("OK".equals(rep.getString("stat"))){
            String date = rep.getString("date");
            JSONArray data = rep.getJSONArray("data");
            IntStream.range(0, 5).forEach(idx -> {
                JSONArray e = data.getJSONArray(idx);
                String unit = e.getString(0);
                String buy = e.getString(1);
                String sell = e.getString(2);
                logger.debug("{},{},{},{}", date, unit, buy, sell);
                lines.add(String.format("%s,%s,%s,%s", date, unit, buy, sell));
            });
        }
        storage.save(lines, this);

        return true;
    }

    @Override
    public Object rowToPojo(String line) throws ParseException {
        return null;
    }
}
