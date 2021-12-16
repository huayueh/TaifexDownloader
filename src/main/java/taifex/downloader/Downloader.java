package taifex.downloader;

import java.io.InputStream;
import java.text.ParseException;
import java.time.LocalDateTime;

/**
 * User: Harvey
 * Date: 2015/2/24
 */
public interface Downloader {
    void setStart(int sY, int sM, int sD);

    void setEnd(int eY, int eM, int eD);

    void download();

    void update();

    boolean processResponse(InputStream is);

    boolean append();

    LocalDateTime getCurrentTime();

    String getName();

    String getCsvHeader();

}
