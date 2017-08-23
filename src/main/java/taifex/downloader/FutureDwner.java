package taifex.downloader;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.model.pojo.TbFutureHis;
import taifex.model.pojo.TbFutureHisPK;
import taifex.storage.Storage;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class FutureDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(FutureDwner.class);
    private static final String commodity = "all";


    public FutureDwner(URL url, Storage storage) {
        super(url, storage);
        firstLine = "交易日期";
        name = "TB_FUTURE_HIS";
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = getFetchStart();
        String eDate = getFetchEnd();

        URIBuilder builder = new URIBuilder().setPath(ret).
                addParameter("DATA_DATE", sDate).
                addParameter("DATA_DATE1", eDate).
                addParameter("datestart", sDate).
                addParameter("dateend", eDate).
                addParameter("COMMODITY_ID", commodity);
        try {
            ret = builder.build().toString();
        } catch (URISyntaxException e) {

        }

        return ret;
    }

    public List<NameValuePair> postPayload() {
        String sDate = getFetchStart();
        String eDate = getFetchEnd();

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("DATA_DATE", sDate));
        params.add(new BasicNameValuePair("DATA_DATE1", eDate));
        params.add(new BasicNameValuePair("datestart", sDate));
        params.add(new BasicNameValuePair("dateend", eDate));
        params.add(new BasicNameValuePair("COMMODITY_ID", commodity));

        return params;
    }
    @Override
    public Object rowToPojo(String line) throws ParseException {
        String[] strSql = line.split("\\s*,\\s*");
        if (strSql.length < 12) {
            return null;
        }
        //交易日期 ,契約,交割月份,開盤價,最高價,最低價,收盤價,漲跌價,漲跌%,*成交量,結算價,*未沖銷契約數,最後最佳買價,最後最佳賣價,歷史最高價,歷史最低價
        //   0       1     2       3     4      5     6       7     8      9     10       11          12           13          14       15
        String strUpDown = strSql[7].replaceAll("▲", "").replaceAll("▼", "");
        String strUpDownP = strSql[7].replaceAll("▲", "").replaceAll("▼", "").replaceAll("%", "");

        TbFutureHis future = new TbFutureHis();
        TbFutureHisPK pk = new TbFutureHisPK();
        pk.setDate(DateUtils.parseDateStrictly(strSql[0], datePattern));
        pk.setContract(strSql[1]);
        pk.setContractMonth(NumberUtils.toInt(strSql[2]));
        future.setTbFutureHisPK(pk);
        future.setOpenPrice(NumberUtils.toInt(strSql[3]));
        future.setHighPrice(NumberUtils.toInt(strSql[4]));
        future.setLowPrice(NumberUtils.toInt(strSql[5]));
        future.setClosePrice(NumberUtils.toInt(strSql[6]));
        future.setUpdownPrice(NumberUtils.toInt(strUpDown));
        future.setUpdownPercent(NumberUtils.toDouble(strUpDownP));
        future.setVolumn(NumberUtils.toInt(strSql[9]));
        future.setSettlePrice(NumberUtils.toInt(strSql[10]));
        future.setOi(NumberUtils.toInt(strSql[11]));

        if (pk.getContractMonth() == 0) {
            return null;
        }
        return future;
    }
}
