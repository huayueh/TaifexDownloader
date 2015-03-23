package taifex.downloader;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.client.utils.URIBuilder;
import taifex.model.pojo.TbOpHis;
import taifex.model.pojo.TbOpHisPK;
import taifex.storage.Storage;
import taifex.util.Util;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

/**
 * @author Harvey
 */
public class OptionDwner extends AbstractDownloader {
    private static final Logger logger = Logger.getLogger(OptionDwner.class);
    private static final String commodity = "TXO";


    OptionDwner(URL url, Storage storage) {
        super(url, storage);
        table = "TB_OP_HIS";
        firstLine = "交易日期";
    }

    @Override
    protected String getURL() {
        String ret = url.toExternalForm();

        String sDate = getStartDate();
        String eDate = getEndDate();

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

    @Override
    public Object rowToPojo(String line) throws ParseException {
        String[] strSql = line.split("\\s*,\\s*");
        if (strSql.length < 14) {
            return null;
        }
        //交易日期 ,契約,到期月份(週別),履約價,買賣權,開盤價,最高價,最低價,收盤價,成交量,結算價,未沖銷契約數,最後最佳買價,最後最佳賣價,歷史最高價,歷史最低價
        //   0       1        2          3     4      5     6       7     8     9     10       11          12           13          14       15
        TbOpHis tbop = new TbOpHis();
        TbOpHisPK pk = new TbOpHisPK();
        pk.setDate(DateUtils.parseDateStrictly(strSql[0], datePattern));
        pk.setContract(strSql[1]);
        pk.setContractMonth(strSql[2]);
        pk.setExcercisePrice(NumberUtils.toInt(strSql[3]));
        pk.setOptionType(strSql[4]);
        tbop.setTbOpHisPK(pk);
        tbop.setOpenPrice(NumberUtils.toDouble(strSql[5]));
        tbop.setHighPrice(NumberUtils.toDouble(strSql[6]));
        tbop.setLowPrice(NumberUtils.toDouble(strSql[7]));
        tbop.setClosePrice(NumberUtils.toDouble(strSql[8]));
        tbop.setVolumn(NumberUtils.toInt(strSql[9]));
        tbop.setSettlePrice(NumberUtils.toDouble(strSql[10]));
        tbop.setOi(NumberUtils.toInt(strSql[11]));
        tbop.setLastBuyPrice(NumberUtils.toDouble(strSql[12]));
        tbop.setLastSellPrice(NumberUtils.toDouble(strSql[13]));
        return tbop;
    }
}
