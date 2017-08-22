package taifex.downloader;

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

    LocalDateTime getCurrentTime();

    String getName();

    String getFirstLine();

    Object rowToPojo(String line) throws ParseException;
}
