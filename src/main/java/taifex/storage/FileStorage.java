package taifex.storage;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.downloader.Downloader;


import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * User: Harvey
 * Date: 2017/8/21
 */
public class FileStorage implements Storage {
    private static final Logger logger = LoggerFactory.getLogger(FileStorage.class);
    private final String ROOT_PATH;

    public FileStorage(String rootPath){
        ROOT_PATH = rootPath;
    }

    @Override
    public boolean save(InputStream is, Downloader downloader) {
        try {
            File targetFile = new File(ROOT_PATH + File.separator + downloader.getName() + File.separator + downloader.getCurrentTime().format(DateTimeFormatter.ofPattern("yyyy_MM")) + ".csv");
            FileUtils.copyInputStreamToFile(is, targetFile);
            logger.debug("saved target file: {}", targetFile);
            return true;
        } catch (IOException e) {
            logger.error("{}", e);
        }
        return false;
    }

    @Override
    public Date getLastDate(Downloader downloader) {
        Date date = null;

        return date;
    }
}
