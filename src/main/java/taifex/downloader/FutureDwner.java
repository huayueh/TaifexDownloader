package taifex.downloader;

import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.storage.Storage;

/**
 * @author Harvey
 */
public class FutureDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(FutureDwner.class);
    private static final String commodity = "all";


    public FutureDwner(URL url, Storage storage) {
        super(url, storage);
        firstLine = "交易日期";
        name = "TB_FUTURE_HIS";
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = getFetchStart();
        String eDate = getFetchEnd();

        URIBuilder builder = new URIBuilder().setScheme(url.getProtocol()).
                setHost(url.getHost()).
                setPath(url.getPath()).
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
}
