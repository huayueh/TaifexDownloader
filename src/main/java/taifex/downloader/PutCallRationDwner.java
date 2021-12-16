package taifex.downloader;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.storage.Storage;

/**
 * @author Harvey
 */
class PutCallRationDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(PutCallRationDwner.class);

    public PutCallRationDwner(URL url, Storage storage) {
        super(url, storage);
        this.name = "TB_PUT_CALL_RATIO";
        this.firstLine = "日期";
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = getFetchStart();
        String eDate = getFetchEnd();

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
    protected List<NameValuePair> postPayload() {
        String sDate = getFetchStart();
        String eDate = getFetchEnd();

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("down_type", ""));
        params.add(new BasicNameValuePair("queryStartDate", sDate));
        params.add(new BasicNameValuePair("queryEndDate", eDate));

        return params;
    }
}
