package taifex.downloader;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.storage.FileStorage;
import taifex.storage.Storage;

/**
 *
 * @author Harvey
 */
public class TwseRunner {
    private static final Logger logger = LoggerFactory.getLogger(TwseRunner.class);

    public static void main(String arg[]){
        Storage twseStorage = new FileStorage("target/Twse");
        Downloader downloader;

        int theYear = Integer.valueOf(arg[0]);
        int theMonth = Integer.valueOf(arg[1]);
        int today = Integer.valueOf(arg[2]);

        logger.info("year:{} month:{} day:{}", theYear, theMonth, today);

        runDownloads(twseStorage, theYear, theMonth, today);
    }

    // Method to allow setting a custom factory for testing
    public static void setDownloaderFactory(DownloaderFactory factory) {
        TwseRunner.downloaderFactory = factory;
    }

    private static DownloaderFactory downloaderFactory = new DefaultDownloaderFactory();

    public static void runDownloads(Storage storage, int theYear, int theMonth, int today) {
        Downloader downloader;
        try {
            downloader = downloaderFactory.createTwseInsDwner(new URL("https://www.twse.com.tw/fund/BFI82U"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createCreditTransDwner(new URL("https://www.twse.com.tw/exchangeReport/MI_MARGN"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createBorrowSellDwner(new URL("https://www.twse.com.tw/exchangeReport/TWT93U"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createTwseDwner(new URL("https://www.twse.com.tw/indicesReport/MI_5MINS_HIST"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createTwseVolDwner(new URL("https://www.twse.com.tw/exchangeReport/FMTQIK"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();
        } catch (MalformedURLException ex) {
            logger.error("{}", ex);
        }
    }
}
