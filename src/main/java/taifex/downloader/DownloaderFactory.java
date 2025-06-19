package taifex.downloader;

import taifex.storage.Storage;
import java.net.URL;

public interface DownloaderFactory {
    Downloader createOptionDwner(URL url, Storage storage);
    Downloader createFutureDwner(URL url, Storage storage);
    Downloader createFutureInsDwner(URL url, Storage storage);
    Downloader createOpInsDwner(URL url, Storage storage);
    Downloader createFutureBigTraderOiDwner(URL url, Storage storage);
    Downloader createOpBigTraderOiDwner(URL url, Storage storage);

    // Methods for TWSE downloaders
    Downloader createTwseInsDwner(URL url, Storage storage);
    Downloader createCreditTransDwner(URL url, Storage storage);
    Downloader createBorrowSellDwner(URL url, Storage storage);
    Downloader createTwseDwner(URL url, Storage storage);
    Downloader createTwseVolDwner(URL url, Storage storage);
}
