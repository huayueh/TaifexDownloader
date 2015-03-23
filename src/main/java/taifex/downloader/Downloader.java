package taifex.downloader;

import java.text.ParseException;

/**
 * User: Harvey
 * Date: 2015/2/24
 * Time: 下午 03:07
 */
public interface Downloader {
    void setStart(int sY, int sM, int sD);

    void setEnd(int eY, int eM, int eD);

    void download();

    void update();

    String getTableName();

    String getFirstLine();

    Object rowToPojo(String line) throws ParseException;
}
