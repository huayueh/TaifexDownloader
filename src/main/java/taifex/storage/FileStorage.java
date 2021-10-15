package taifex.storage;

import static org.apache.commons.io.FileUtils.openOutputStream;
import static org.apache.commons.io.IOUtils.LINE_SEPARATOR;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.downloader.Downloader;


import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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
            if (downloader.append()) {
                FileOutputStream output = openOutputStream(targetFile, true);
                try {
                    IOUtils.copy(is, output);
                    output.close();
                } finally {
                    IOUtils.closeQuietly(output);
                }
            } else {
                FileUtils.copyInputStreamToFile(is, targetFile);
            }
            logger.debug("saved target file: {}", targetFile);
            return true;
        } catch (IOException e) {
            logger.error("{}", e);
        }
        return false;
    }

    @Override
    public boolean save(List<String> lines, Downloader downloader) {
        if (!downloader.append()) {
            throw new IllegalStateException("saving line must be append mode downloader");
        }
        try {
            File targetFile = new File(ROOT_PATH + File.separator + downloader.getName() + File.separator + downloader.getCurrentTime().format(DateTimeFormatter.ofPattern("yyyy_MM")) + ".csv");
            FileOutputStream output = openOutputStream(targetFile, true);
            try {
                IOUtils.writeLines(lines, LINE_SEPARATOR, output, "UTF-8");
                output.close();
            } finally {
                IOUtils.closeQuietly(output);
            }
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
