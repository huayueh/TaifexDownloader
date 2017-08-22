package taifex.downloader;

import taifex.storage.DatabaseStorage;
import taifex.storage.FileStorage;
import taifex.storage.Storage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harvey
 */
public class RunDwnerv2 {

    public static void main(String arg[]){
        Storage storage = new FileStorage("target/Taifex");
//        Storage storage = new DatabaseStorage();
        Downloader downloader = null;
        
        try {
            //----------------盤後資訊---------------------------------------------------
            downloader = new OptionDwner(new URL("http://www.taifex.com.tw/chinese/3/3_2_3_b.asp"), storage);     //選擇權每日交易行情   2001/12/24
            downloader.setStart(2011, 12, 24);
            downloader.setEnd(2017, 8, 20);
            downloader.download();

            downloader = new FutureDwner(new URL("http://www.taifex.com.tw/chinese/3/3_1_2dl.asp"), storage);     //期貨每日交易行情    1998/7/21
            downloader.setStart(1998, 7, 21);
            downloader.setEnd(2017, 8, 20);
            downloader.download();
            //-----------------------------------------------------------------------------------

            //----------------三大法人 only 3 years ago--------------------------------------------
            downloader = new FutureInsDwner(new URL("http://www.taifex.com.tw/chinese/3/7_12_8dl.asp"), storage);        //三大法人交易情形統計(區分各期貨契約)-依日期
            downloader.setStart(2014, 8, 22);
            downloader.setEnd(2017, 8, 22);
            downloader.download();

            downloader = new OpInsDwner(new URL("http://www.taifex.com.tw/chinese/3/7_12_10dl.asp"), storage);       //三大法人交易情形統計(區分各選擇權契約)-依日期
            downloader.setStart(2014, 8, 22);
            downloader.setEnd(2017, 8, 22);
            downloader.download();
            //-----------------------------------------------------------------------------------

            //----------------大額交易人---------------------------------------------------
            downloader = new FutureBigTraderOiDwner(new URL("http://www.taifex.com.tw/chinese/3/7_8_1dl.asp"), storage);        //期貨大額交易人未沖銷部位結構表      2004/7/1
            downloader.setStart(2004, 7, 1);
            downloader.setEnd(2017, 8, 20);
            downloader.download();

            downloader = new OpBigTraderOiDwner(new URL("http://www.taifex.com.tw/chinese/3/7_9_1dl.asp"), storage);  //選擇權大額交易人      2004/7/1
            downloader.setStart(2004, 7, 1);
            downloader.setEnd(2017, 8, 20);
            downloader.download();
            //-----------------------------------------------------------------------------------
            
            //----------------選擇權比率---------------------------------------------------
            downloader = new PutCallRationDwner(new URL("http://www.taifex.com.tw/chinese/3/PCRatio.asp"), storage); //選擇權每日交易行情   2001/12/24
            downloader.setStart(2001, 12, 24);
            downloader.setEnd(2017, 8, 20);
            downloader.download();
            //-----------------------------------------------------------------------------------
            
            //----------------結算價 no work-----------------------------------------------
//            downloader = new SettleDwner(new URL("http://www.taifex.com.tw/chinese/5/FSPDownload.asp?menuid1=03"), storage); //選擇權每日交易行情   2001/12/24
//            downloader.setStart(2001, 12, 24);
//            downloader.setEnd(2017, 8, 20);
//            downloader.download();
            //-----------------------------------------------------------------------------------
        } catch (MalformedURLException ex) {
            Logger.getLogger(RunDwnerv2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
