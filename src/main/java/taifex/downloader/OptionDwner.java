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
public class OptionDwner extends AbstractDownloader {
    private static final Logger logger = LoggerFactory.getLogger(OptionDwner.class);
    private static final String commodity = "all";


    OptionDwner(URL url, Storage storage) {
        super(url, storage);
        name = "TB_OP_HIS";
        firstLine = "交易日期";
    }

    @Override
    protected String getParams() {
        String ret = url.toExternalForm();

        String sDate = getFetchStart();
        String eDate = getFetchEnd();

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

}
