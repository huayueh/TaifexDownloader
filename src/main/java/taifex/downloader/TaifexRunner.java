package taifex.downloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.storage.FileStorage;
import taifex.storage.Storage;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Harvey
 */
public class TaifexRunner {
    private static final Logger logger = LoggerFactory.getLogger(TaifexRunner.class);
    private static DownloaderFactory downloaderFactory = new DefaultDownloaderFactory();

    public static void main(String arg[]){
        Storage storage = new FileStorage("target/Taifex");
        int theYear = Integer.valueOf(arg[0]);
        int theMonth = Integer.valueOf(arg[1]);
        int today = Integer.valueOf(arg[2]);

        logger.info("year:{} month:{} day:{}", theYear, theMonth, today);

        runDownloads(storage, theYear, theMonth, today);
    }

    // Method to allow setting a custom factory for testing
    public static void setDownloaderFactory(DownloaderFactory factory) {
        downloaderFactory = factory;
    }

    public static void runDownloads(Storage storage, int theYear, int theMonth, int today) {
        Downloader downloader;
        try {
            downloader = downloaderFactory.createOptionDwner(new URL("https://www.taifex.com.tw/cht/3/optDataDown"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createFutureDwner(new URL("https://www.taifex.com.tw/cht/3/futDataDown"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createFutureInsDwner(new URL("https://www.taifex.com.tw/cht/3/futContractsDateDown"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createOpInsDwner(new URL("https://www.taifex.com.tw/cht/3/callsAndPutsDateDown"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createFutureBigTraderOiDwner(new URL("https://www.taifex.com.tw/cht/3/largeTraderFutDown"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = downloaderFactory.createOpBigTraderOiDwner(new URL("https://www.taifex.com.tw/cht/3/largeTraderOptDown"), storage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();
        } catch (MalformedURLException ex) {
            logger.error("{}", ex);
        }
    }
}
