package taifex.downloader;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import taifex.model.pojo.TbPutCallRatio;
import taifex.storage.Storage;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;

/**
 * @author Harvey
 */
class PutCallRationDwner extends AbstractDownloader {
    private static final Logger logger = Logger.getLogger(PutCallRationDwner.class);

    public PutCallRationDwner(URL url, Storage storage) {
        super(url, storage);
        this.table = "TB_PUT_CALL_RATIO";
        this.firstLine = "日期";
    }

    @Override
    protected String getURL() {
        String ret = url.toExternalForm();

        String sDate = getStartDate();
        String eDate = getEndDate();

        URIBuilder builder = new URIBuilder().setPath(ret).
                addParameter("download", "1").
                addParameter("datestart", sDate).
                addParameter("dateend", eDate);
        try {
            ret = builder.build().toString();
        } catch (URISyntaxException e) {

        }

        return ret;
    }

    @Override
    public Object rowToPojo(String line) throws ParseException {
        String[] strSql = line.split("\\s*,\\s*");
        if (strSql.length < 7) {
            return null;
        }
        //日期,賣權成交量,買權成交量,買賣權成交量比率%,賣權未平倉量,買權未平倉量,買賣權未平倉量比率%
        // 0       1        2              3              4           5              6
        TbPutCallRatio tbPutCall = new TbPutCallRatio();
        tbPutCall.setDate(DateUtils.parseDateStrictly(strSql[0], datePattern));
        tbPutCall.setPutVol(NumberUtils.toInt(strSql[1]));
        tbPutCall.setCallVol(NumberUtils.toInt(strSql[2]));
        tbPutCall.setPutCallRationVol(NumberUtils.toDouble(strSql[3]));
        tbPutCall.setPutOi(NumberUtils.toInt(strSql[4]));
        tbPutCall.setCallOi(NumberUtils.toInt(strSql[5]));
        tbPutCall.setPutCallRatioOi(NumberUtils.toDouble(strSql[6]));

        return tbPutCall;
    }
}
