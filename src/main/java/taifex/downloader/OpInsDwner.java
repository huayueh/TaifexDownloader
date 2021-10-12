package taifex.downloader;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.model.pojo.TbOpIns;
import taifex.model.pojo.TbOpInsPK;
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
class OpInsDwner extends AbstractDownloader {

    private static final Logger logger = LoggerFactory.getLogger(OpInsDwner.class);
    private static final String commodity = "";

    public OpInsDwner(URL url, Storage storage) {
        super(url, storage);
        this.name = "TB_OP_INS";
        this.firstLine = "日期";
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        return ret;
    }

    @Override
    protected List<NameValuePair> postPayload() {
        String sDate = getFetchStart();
        String eDate = getFetchEnd();

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("firstDate", sDate + " 00:00"));
        params.add(new BasicNameValuePair("lastDate", eDate + " 00:00"));
        params.add(new BasicNameValuePair("queryStartDate", sDate));
        params.add(new BasicNameValuePair("queryEndDate", eDate));
        params.add(new BasicNameValuePair("commodity_id", commodity));

        return params;
    }

    @Override
    public Object rowToPojo(String line) throws ParseException {
        String[] strSql = line.split("\\s*,\\s*");
        if (strSql.length < 16) {
            return null;
        }
        //日期,商品名稱,買賣權別,身份別,買方交易口數,買方交易契約金額(千元),賣方交易口數,賣方交易契約金額(千元),交易口數買賣淨額,交易契約金額買賣淨額(千元),買方未平倉口數,買方未平倉契約金額(千元),賣方未平倉口數,賣方未平倉契約金額(千元),未平倉口數買賣淨額,未平倉契約金額買賣淨額(千元)
        // 0      1       2       3        4                5                 6                7                   8                 9                     10                 11                12              13                    14                  15
        TbOpIns tbOpIns = new TbOpIns();
        TbOpInsPK pk = new TbOpInsPK();
        pk.setDate(DateUtils.parseDateStrictly(strSql[0], datePattern));
        pk.setContract(strSql[1]);
        pk.setBuyCall(strSql[2]);
        pk.setTraderType(strSql[3]);
        tbOpIns.setTbOpInsPK(pk);
        tbOpIns.setBuyCnt(NumberUtils.toInt(strSql[4]));
        tbOpIns.setBuyAmt(NumberUtils.toInt(strSql[5]));
        tbOpIns.setSellCnt(NumberUtils.toInt(strSql[6]));
        tbOpIns.setSellAmt(NumberUtils.toInt(strSql[7]));
        tbOpIns.setCntNet(NumberUtils.toInt(strSql[8]));
        tbOpIns.setAmtNet(NumberUtils.toInt(strSql[9]));
        tbOpIns.setBuyOiCnt(NumberUtils.toInt(strSql[10]));
        tbOpIns.setBuyOiAmt(NumberUtils.toInt(strSql[11]));
        tbOpIns.setSellOiCnt(NumberUtils.toInt(strSql[12]));
        tbOpIns.setSellOiAmt(NumberUtils.toInt(strSql[13]));
        tbOpIns.setCntOiNet(NumberUtils.toInt(strSql[14]));
        tbOpIns.setAmtOiNet(NumberUtils.toInt(strSql[15]));

        return tbOpIns;
    }
}
