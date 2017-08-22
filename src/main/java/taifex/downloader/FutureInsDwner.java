package taifex.downloader;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import taifex.model.pojo.TbFutureIns;
import taifex.model.pojo.TbFutureInsPK;
import taifex.storage.Storage;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
class FutureInsDwner extends AbstractDownloader {

    private static final Logger logger = Logger.getLogger(FutureInsDwner.class);
    private static final String commodity = "";

    public FutureInsDwner(URL url, Storage storage) {
        super(url, storage);
        this.name = "TB_FUTURE_INS";
        this.firstLine = "日期";
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = getFetchStart();
        String eDate = getFetchEnd();

        String[] sDateAry = StringUtils.split(sDate, "/");
        String[] eDateAry = StringUtils.split(eDate, "/");

        URIBuilder builder = new URIBuilder().setPath(ret).
                addParameter("DATA_DATE_Y", sDateAry[0]).
                addParameter("DATA_DATE_M", sDateAry[1]).
                addParameter("DATA_DATE_D", sDateAry[2]).
                addParameter("DATA_DATE_Y_E", eDateAry[0]).
                addParameter("DATA_DATE_M_E", eDateAry[1]).
                addParameter("DATA_DATE_D_E", eDateAry[2]).
                addParameter("syear", sDateAry[0]).
                addParameter("smonth", sDateAry[1]).
                addParameter("sday", sDateAry[2]).
                addParameter("eyear", eDateAry[0]).
                addParameter("emonth", eDateAry[1]).
                addParameter("eday", eDateAry[2]).
                addParameter("datestart", sDate).
                addParameter("dateend", eDate).
                addParameter("COMMODITY_ID", commodity);
        try {
            ret = builder.build().toString();
        } catch (URISyntaxException e) {

        }

        return ret;
    }

    @Override
    protected List<NameValuePair> postPayload() {
        String sDate = getFetchStart();
        String eDate = getFetchEnd();

        String[] sDateAry = StringUtils.split(sDate, "/");
        String[] eDateAry = StringUtils.split(eDate, "/");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("DATA_DATE_Y", sDateAry[0]));
        params.add(new BasicNameValuePair("DATA_DATE_M", sDateAry[1]));
        params.add(new BasicNameValuePair("DATA_DATE_D", sDateAry[2]));
        params.add(new BasicNameValuePair("DATA_DATE_Y_E", eDateAry[0]));
        params.add(new BasicNameValuePair("DATA_DATE_M_E", eDateAry[1]));
        params.add(new BasicNameValuePair("DATA_DATE_D_E", eDateAry[2]));
        params.add(new BasicNameValuePair("syear", sDateAry[0]));
        params.add(new BasicNameValuePair("smonth", sDateAry[1]));
        params.add(new BasicNameValuePair("sday", sDateAry[2]));
        params.add(new BasicNameValuePair("eyear", eDateAry[0]));
        params.add(new BasicNameValuePair("emonth", eDateAry[1]));
        params.add(new BasicNameValuePair("eday", eDateAry[2]));
        params.add(new BasicNameValuePair("datestart", sDate));
        params.add(new BasicNameValuePair("dateend", eDate));
        params.add(new BasicNameValuePair("COMMODITY_ID", commodity));

        return params;
    }

    @Override
    public Object rowToPojo(String line) throws ParseException {
        String[] strSql = line.split("\\s*,\\s*");
        if (strSql.length < 15) {
            return null;
        }
        //日期,商品名稱,身份別,多方交易口數,多方交易契約金額(千元),空方交易口數,空方交易契約金額(千元),多空交易口數淨額,多空交易契約金額淨額(千元),多方未平倉口數,多方未平倉契約金額(千元),空方未平倉口數,空方未平倉契約金額(千元),多空未平倉口數淨額,多空未平倉契約金額淨額(千元)
        // 0      1       2        3             4                     5            6                    7                   8                    9             10                     11           12                      13                    14
        TbFutureIns tbFutureIns = new TbFutureIns();
        TbFutureInsPK pk = new TbFutureInsPK();
        pk.setDate(DateUtils.parseDateStrictly(strSql[0], datePattern));
        pk.setContract(strSql[1]);
        pk.setTraderType(strSql[2]);
        tbFutureIns.setTbFutureInsPK(pk);
        tbFutureIns.setBuyCnt(NumberUtils.toInt(strSql[3]));
        tbFutureIns.setBuyAmt(NumberUtils.toInt(strSql[4]));
        tbFutureIns.setSellCnt(NumberUtils.toInt(strSql[5]));
        tbFutureIns.setSellAmt(NumberUtils.toInt(strSql[6]));
        tbFutureIns.setCntNet(NumberUtils.toInt(strSql[7]));
        tbFutureIns.setAmtNet(NumberUtils.toInt(strSql[8]));
        tbFutureIns.setBuyOiCnt(NumberUtils.toInt(strSql[9]));
        tbFutureIns.setBuyOiAmt(NumberUtils.toInt(strSql[10]));
        tbFutureIns.setSellOiCnt(NumberUtils.toInt(strSql[11]));
        tbFutureIns.setSellOiAmt(NumberUtils.toInt(strSql[12]));
        tbFutureIns.setCntOiNet(NumberUtils.toInt(strSql[13]));
        tbFutureIns.setAmtOiNet(NumberUtils.toInt(strSql[14]));

        return tbFutureIns;
    }
}
