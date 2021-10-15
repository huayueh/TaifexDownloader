package taifex.storage;

import taifex.downloader.Downloader;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * User: Harvey
 * Date: 2015/3/3
 * Time: 下午 06:21
 */
public interface Storage {
    boolean save(InputStream is, Downloader downloader);
    boolean save(List<String> line, Downloader downloader);
    Date getLastDate(Downloader downloader);
}
