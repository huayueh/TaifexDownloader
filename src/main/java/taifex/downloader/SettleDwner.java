package taifex.downloader;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.client.utils.URIBuilder;
import taifex.model.pojo.TbContractOut;
import taifex.model.pojo.TbContractOutPK;
import taifex.storage.Storage;
import taifex.util.Util;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

/**
 * @author Harvey
 */
class SettleDwner extends AbstractDownloader {

    private static final Logger logger = Logger.getLogger(SettleDwner.class);

    public SettleDwner(URL url, Storage storage) {
        super(url, storage);
        this.table = "TB_CONTRACT_OUT";
        this.firstLine = "最後結算日";
    }

    @Override
    protected String getURL() {
        String ret = url.toExternalForm();

        String sDate = getStartDate();
        String eDate = getEndDate();

        String[] sDateAry = StringUtils.split(sDate, "/");
        String[] eDateAry = StringUtils.split(eDate, "/");

        URIBuilder builder = new URIBuilder().setPath(ret).
                addParameter("download", "1").
                addParameter("syear", sDateAry[0]).
                addParameter("smonth", sDateAry[1]).
                addParameter("eyear", eDateAry[0]).
                addParameter("emonth", eDateAry[1]).
                addParameter("cate", "1");
        try {
            ret = builder.build().toString();
        } catch (URISyntaxException e) {

        }

        return ret;
    }

    @Override
    public Object rowToPojo(String line) throws ParseException {
        String[] strSql = line.split("\\s*,\\s*");
        if (strSql.length < 5) {
            return null;
        }
        //最後結算日,契約月份,商品代號,商品名稱,最後結算價
        // 0            1       2        3        4    
        TbContractOut tbCotractOut = new TbContractOut();
        TbContractOutPK pk = new TbContractOutPK();
        pk.setDate(DateUtils.parseDateStrictly(strSql[0], datePattern));
        pk.setContractMonth(strSql[1]);
        pk.setContract(strSql[2]);
        tbCotractOut.setTbContractOutPK(pk);
        tbCotractOut.setContractName(strSql[3]);
        tbCotractOut.setPrice(NumberUtils.toDouble(strSql[4]));

        return tbCotractOut;
    }

    @Override
    protected void setDownloadTime() {
        calStart.add(Calendar.MONTH, 1);
    }
}
