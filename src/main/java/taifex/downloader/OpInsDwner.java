package taifex.downloader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.storage.Storage;

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
}
