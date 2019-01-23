package taifex.downloader;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.model.pojo.TbOpBigtraderOi;
import taifex.model.pojo.TbOpBigtraderOiPK;
import taifex.storage.Storage;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
class OpBigTraderOiDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(OpBigTraderOiDwner.class);

    public OpBigTraderOiDwner(URL url, Storage storage) {
        super(url, storage);
        this.name = "TB_OP_BIGTRADER_OI";
        this.firstLine = "日期";
    }

    @Override
    public Object rowToPojo(String line) throws ParseException {
        String[] strSql = line.split("\\s*,\\s*");
        if (strSql.length < 11) {
            return null;
        }
        //日期,商品(契約),商品名稱(契約名稱),買賣權,到期月份(週別),交易人類別,前五大交易人買方,前五大交易人賣方,前十大交易人買方,前十大交易人賣方,全市場未沖銷部位數
        // 0       1        2                 3         4           5            6                7              8               9             10
        if (strSql[4].equals("-") || strSql[5].equals("-")) {
            return null;
        }
        TbOpBigtraderOi tbOpBigTrader = new TbOpBigtraderOi();
        TbOpBigtraderOiPK pk = new TbOpBigtraderOiPK();
        pk.setDate(DateUtils.parseDateStrictly(strSql[0], datePattern));
        pk.setContract(strSql[1]);
        tbOpBigTrader.setContractName(strSql[2]);
        pk.setPutCall(strSql[3]);
        pk.setContractMonth(strSql[4]);
        pk.setTraderType(strSql[5]);
        tbOpBigTrader.setTbOpBigtraderOiPK(pk);
        tbOpBigTrader.setTop5BuyOi(NumberUtils.toInt(strSql[6]));
        tbOpBigTrader.setTop5SellOi(NumberUtils.toInt(strSql[7]));
        tbOpBigTrader.setTop10BuyOi(NumberUtils.toInt(strSql[8]));
        tbOpBigTrader.setTop10SellOi(NumberUtils.toInt(strSql[9]));
        tbOpBigTrader.setWholeMarket(NumberUtils.toInt(strSql[10]));

        return tbOpBigTrader;
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

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("queryStartDate", sDate));
        params.add(new BasicNameValuePair("queryEndDate", eDate));

        return params;
    }

}
