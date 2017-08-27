package taifex.downloader;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.model.pojo.TbContractOut;
import taifex.model.pojo.TbContractOutPK;
import taifex.storage.Storage;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Harvey
 */
class SettleDwner extends AbstractDownloader {

    private static final Logger logger = LoggerFactory.getLogger(SettleDwner.class);

    public SettleDwner(URL url, Storage storage) {
        super(url, storage);
        this.name = "TB_CONTRACT_OUT";
        this.firstLine = "最後結算日";
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

        String[] sDateAry = StringUtils.split(sDate, "/");
        String[] eDateAry = StringUtils.split(eDate, "/");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("download", "1"));
        params.add(new BasicNameValuePair("syear", sDateAry[0]));
        params.add(new BasicNameValuePair("smonth", sDateAry[1]));
        params.add(new BasicNameValuePair("eyear", eDateAry[0]));
        params.add(new BasicNameValuePair("emonth", eDateAry[1]));
        params.add(new BasicNameValuePair("cate", "7"));
        params.add(new BasicNameValuePair("cateId", ""));

        return params;
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

}
