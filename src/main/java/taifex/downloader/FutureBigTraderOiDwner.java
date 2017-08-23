package taifex.downloader;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.model.pojo.TbFutureBigtraderOi;
import taifex.model.pojo.TbFutureBigtraderOiPK;
import taifex.storage.Storage;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
class FutureBigTraderOiDwner extends AbstractDownloader {

    private static final Logger logger = LoggerFactory.getLogger(FutureBigTraderOiDwner.class);

    public FutureBigTraderOiDwner(URL url, Storage storage) {
        super(url, storage);
        this.name = "TB_FUTURE_BIGTRADER_OI";
        this.firstLine = "日期";
    }

    @Override
    public Object rowToPojo(String line) throws ParseException {
        String[] strSql = line.split("\\s*,\\s*");
        if (strSql.length < 10) {
            return null;
        }
        //日期,商品(契約),商品名稱(契約名稱),月份類別,交易人類別,前五大交易人買方,前五大交易人賣方,前十大交易人買方,前十大交易人賣方,全市場未沖銷部位數
        // 0       1        2                 3         4           5              6                7              8               9
        TbFutureBigtraderOi tbFuBigTrader = new TbFutureBigtraderOi();
        TbFutureBigtraderOiPK pk = new TbFutureBigtraderOiPK();
        pk.setDate(DateUtils.parseDateStrictly(strSql[0], datePattern));
        pk.setContract(strSql[1]);
        tbFuBigTrader.setContractName(strSql[2]);
        pk.setContractMonth(NumberUtils.toInt(strSql[3]));
        pk.setTraderType(strSql[4]);
        tbFuBigTrader.setTbFutureBigtraderOiPK(pk);
        tbFuBigTrader.setTop5BuyOi(NumberUtils.toInt(strSql[5]));
        tbFuBigTrader.setTop5SellOi(NumberUtils.toInt(strSql[6]));
        tbFuBigTrader.setTop10BuyOi(NumberUtils.toInt(strSql[7]));
        tbFuBigTrader.setTop10SellOi(NumberUtils.toInt(strSql[8]));
        tbFuBigTrader.setWholeMarket(NumberUtils.toInt(strSql[9]));

        return tbFuBigTrader;
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = getFetchStart();
        String eDate = getFetchEnd();

        String[] sDateAry = StringUtils.split(sDate, "/");
        String[] eDateAry = StringUtils.split(eDate, "/");

        URIBuilder builder = new URIBuilder().setPath(ret).
                addParameter("syear", sDateAry[0]).
                addParameter("smonth", sDateAry[1]).
                addParameter("sday", sDateAry[2]).
                addParameter("eyear", eDateAry[0]).
                addParameter("emonth", eDateAry[1]).
                addParameter("eday", eDateAry[2]).
                addParameter("datestart", sDate).
                addParameter("dateend", eDate);
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
        params.add(new BasicNameValuePair("syear", sDateAry[0]));
        params.add(new BasicNameValuePair("smonth", sDateAry[1]));
        params.add(new BasicNameValuePair("sday", sDateAry[2]));
        params.add(new BasicNameValuePair("eyear", eDateAry[0]));
        params.add(new BasicNameValuePair("emonth", eDateAry[1]));
        params.add(new BasicNameValuePair("eday", eDateAry[2]));
        params.add(new BasicNameValuePair("datestart", sDate));
        params.add(new BasicNameValuePair("dateend", eDate));

        return params;
    }
}
