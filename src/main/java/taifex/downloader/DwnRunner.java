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
public class DwnRunner {
    private static final Logger logger = LoggerFactory.getLogger(DwnRunner.class);

    public static void main(String arg[]){
        Storage storage = new FileStorage("target/Taifex");
        Storage twseStorage = new FileStorage("target/Taifex");
        Downloader downloader;
        int theYear = 2021;
        int theMonth = 12;
        int today = 16;

        try {
            //----------------盤後資訊---------------------------------------------------
            downloader = new OptionDwner(new URL("https://www.taifex.com.tw/cht/3/optDataDown"), storage);     //選擇權每日交易行情   2001/12/24
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = new FutureDwner(new URL("https://www.taifex.com.tw/cht/3/futDataDown"), storage);     //期貨每日交易行情    1998/7/21
//            downloader.setStart(1998, 7, 21);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();
            //-----------------------------------------------------------------------------------

            //----------------三大法人 only 3 years ago--------------------------------------------
            downloader = new FutureInsDwner(new URL("https://www.taifex.com.tw/cht/3/futContractsDateDown"), storage);        //三大法人交易情形統計(區分各期貨契約)-依日期
//            downloader.setStart(2014, 8, 22);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

//            //買賣權分計=>much more meaningful. Use this as TB_OP_INS
            downloader = new OpInsDwner(new URL("https://www.taifex.com.tw/cht/3/callsAndPutsDateDown"), storage);       //三大法人交易情形統計(區分各選擇權契約)-依日期
//            downloader.setStart(2014, 8, 22);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();
            //-----------------------------------------------------------------------------------

            //----------------大額交易人---------------------------------------------------
            downloader = new FutureBigTraderOiDwner(new URL("https://www.taifex.com.tw/cht/3/largeTraderFutDown"), storage);        //期貨大額交易人未沖銷部位結構表      2004/7/1
//            downloader.setStart(2004, 7, 1);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            downloader = new OpBigTraderOiDwner(new URL("https://www.taifex.com.tw/cht/3/largeTraderOptDown"), storage);  //選擇權大額交易人      2004/7/1
//            downloader.setStart(2004, 7, 1);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today);
            downloader.download();

            //----------------TWSE-----------------------------------------------
            //----------------三大法人買賣超-----------------------------------------------
            downloader = new TwseInsDwner(new URL("https://www.twse.com.tw/fund/BFI82U"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today+1);
            downloader.download();

            //----------------融資融券餘額----------------------------------------------------
            downloader = new CreditTransDwner(new URL("https://www.twse.com.tw/exchangeReport/MI_MARGN"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today+1);
            downloader.download();

            //------------------借券賣出--------------------------------------------------------
            downloader = new BorrowSellDwner(new URL("https://www.twse.com.tw/exchangeReport/TWT93U"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today+1);
            downloader.download();

            //------------------歷史資料--------------------------------------------------------
            downloader = new TwseDwner(new URL("https://www.twse.com.tw/indicesReport/MI_5MINS_HIST"), twseStorage);
            downloader.setStart(theYear, theMonth, 1);
            downloader.setEnd(theYear, theMonth, today+1);
            downloader.download();
        } catch (MalformedURLException ex) {
            logger.error("{}", ex);

        }

    }
}
