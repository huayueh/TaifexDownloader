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
public class BorrowSellDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(BorrowSellDwner.class);

    public BorrowSellDwner(URL url, Storage storage) {
        super(url, storage);
        name = "BORROW_SELL";
        firstLine = "日期,股票代號,股票名稱," +
                "前日餘額,賣出,買進,現券,今日餘額,限額," +
                "前日餘額,當日賣出,當日還券,當日調整,當日餘額,次一營業日可限額" + IOUtils.LINE_SEPARATOR;
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
            IntStream.range(0, data.length()).forEach(idx -> {
                // "股票代號", "股票名稱",
                // "前日餘額", "賣出", "買進", "現券", "今日餘額", "限額",
                // "前日餘額", "當日賣出", "當日還券", "當日調整", "當日餘額", "次一營業日可限額", "備註"
                JSONArray e = data.getJSONArray(idx);
                String symbol = e.getString(0);
                String name = e.getString(1);

                String yesterdayAmt = e.getString(2);
                String sell = e.getString(3);
                String buy = e.getString(4);
                String shortt = e.getString(5);
                String today = e.getString(6);
                String quota = e.getString(7);

                String borrowYesterday = e.getString(8);
                String todaySell = e.getString(9);
                String todayReimburse = e.getString(10);
                String todayAdj = e.getString(11);
                String todayRemains = e.getString(12);
                String nextDayQuota = e.getString(13);
                String note = e.getString(14);

                yesterdayAmt = StringUtils.remove(yesterdayAmt, ",");
                sell = StringUtils.remove(sell, ",");
                buy = StringUtils.remove(buy, ",");
                shortt = StringUtils.remove(shortt, ",");
                today = StringUtils.remove(today, ",");
                quota = StringUtils.remove(quota, ",");
                borrowYesterday = StringUtils.remove(borrowYesterday, ",");
                todaySell = StringUtils.remove(todaySell, ",");
                todayReimburse = StringUtils.remove(todayReimburse, ",");
                todayAdj = StringUtils.remove(todayAdj, ",");
                todayRemains = StringUtils.remove(todayRemains, ",");
                nextDayQuota = StringUtils.remove(nextDayQuota, ",");


//                logger.debug("{},{},{},{},{},{},{}", date, symbol, name, buy, sell, buy, shortt);
                lines.add(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", date, symbol, name,
                        yesterdayAmt, sell, buy, shortt, today, quota,
                        borrowYesterday, todaySell, todayReimburse, todayAdj, todayRemains, nextDayQuota));
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
