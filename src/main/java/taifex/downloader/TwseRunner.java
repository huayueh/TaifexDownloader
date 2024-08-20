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

        try {
            //----------------TWSE-----------------------------------------------
            //----------------三大法人買賣超-----------------------------------------------
            downloader = new TwseInsDwner(new URL("https://www.twse.com.tw/fund/BFI82U"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            //----------------融資融券餘額----------------------------------------------------
            downloader = new CreditTransDwner(new URL("https://www.twse.com.tw/exchangeReport/MI_MARGN"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            //------------------借券賣出--------------------------------------------------------
            downloader = new BorrowSellDwner(new URL("https://www.twse.com.tw/exchangeReport/TWT93U"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            //------------------歷史資料--------------------------------------------------------
            downloader = new TwseDwner(new URL("https://www.twse.com.tw/indicesReport/MI_5MINS_HIST"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            //------------------交易量歷史資料--------------------------------------------------------
            downloader = new TwseVolDwner(new URL("https://www.twse.com.tw/exchangeReport/FMTQIK"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();
        } catch (MalformedURLException ex) {
            logger.error("{}", ex);

        }

    }
}
