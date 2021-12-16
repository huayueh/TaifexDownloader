package taifex.downloader;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.storage.Storage;

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
