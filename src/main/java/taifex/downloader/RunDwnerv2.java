package taifex.downloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import taifex.storage.DatabaseStorage;
import taifex.storage.FileStorage;
import taifex.storage.Storage;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Harvey
 */
public class RunDwnerv2 {
    private static final Logger logger = LoggerFactory.getLogger(RunDwnerv2.class);

    public static void main(String arg[]){
        Storage storage = new FileStorage("target/Taifex");
//        Storage storage = new DatabaseStorage();
        Downloader downloader = null;

        try {
            //----------------盤後資訊---------------------------------------------------
//            downloader = new OptionDwner(new URL("http://www.taifex.com.tw/cht/3/optDataDown"), storage);     //選擇權每日交易行情   2001/12/24
////            downloader.setStart(2011, 12, 24);
//            downloader.setStart(2018, 6, 1);
//            downloader.setEnd(2019, 1, 21);
//            downloader.download();

//            downloader = new FutureDwner(new URL("http://www.taifex.com.tw/cht/3/futDataDown"), storage);     //期貨每日交易行情    1998/7/21
////            downloader.setStart(1998, 7, 21);
//            downloader.setStart(2018, 6, 1);
//            downloader.setEnd(2019, 1, 21);
//            downloader.download();
//            //-----------------------------------------------------------------------------------
//
//            //----------------三大法人 only 3 years ago--------------------------------------------
//            downloader = new FutureInsDwner(new URL("http://www.taifex.com.tw/cht/3/futContractsDateDown"), storage);        //三大法人交易情形統計(區分各期貨契約)-依日期
////            downloader.setStart(2014, 8, 22);
//            downloader.setStart(2018, 6, 1);
//            downloader.setEnd(2019, 1, 21);
//            downloader.download();
//
//            downloader = new OpInsDwner(new URL("http://www.taifex.com.tw/cht/3/optContractsDateDown"), storage);       //三大法人交易情形統計(區分各選擇權契約)-依日期
////            downloader.setStart(2014, 8, 22);
//            downloader.setStart(2018, 6, 1);
//            downloader.setEnd(2019, 1, 21);
//            downloader.download();
//            //-----------------------------------------------------------------------------------
//
//            //----------------大額交易人---------------------------------------------------
//            downloader = new FutureBigTraderOiDwner(new URL("http://www.taifex.com.tw/cht/3/largeTraderFutDown"), storage);        //期貨大額交易人未沖銷部位結構表      2004/7/1
////            downloader.setStart(2004, 7, 1);
//            downloader.setStart(2018, 6, 1);
//            downloader.setEnd(2019, 1, 21);
//            downloader.download();
//
//            downloader = new OpBigTraderOiDwner(new URL("http://www.taifex.com.tw/cht/3/largeTraderOptDown"), storage);  //選擇權大額交易人      2004/7/1
////            downloader.setStart(2004, 7, 1);
//            downloader.setStart(2018, 6, 1);
//            downloader.setEnd(2019, 1, 21);
//            downloader.download();
//            //-----------------------------------------------------------------------------------
//
//            //----------------選擇權比率---------------------------------------------------
            downloader = new PutCallRationDwner(new URL("http://www.taifex.com.tw/cht/3/pcRatioDown"), storage); //選擇權每日交易行情   2001/12/24
//            downloader.setStart(2001, 12, 24);
            downloader.setStart(2018, 6, 1);
            downloader.setEnd(2019, 1, 21);
            downloader.download();
//            //-----------------------------------------------------------------------------------

            //----------------結算價 no work-----------------------------------------------
//            downloader = new SettleDwner(new URL("http://www.taifex.com.tw/chinese/5/FSPDownload.asp?menuid1=03"), storage); //選擇權每日交易行情   2001/12/24
//            downloader.setStart(2001, 12, 24);
//            downloader.setEnd(2017, 8, 20);
//            downloader.download();
            //-----------------------------------------------------------------------------------
        } catch (MalformedURLException ex) {
            logger.error("{}", ex);

        }

    }
}
