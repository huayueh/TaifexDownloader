package taifex.downloader;

import taifex.storage.Storage;
import java.net.URL;

public class DefaultDownloaderFactory implements DownloaderFactory {
    @Override
    public Downloader createOptionDwner(URL url, Storage storage) {
        return new OptionDwner(url, storage);
    }

    @Override
    public Downloader createFutureDwner(URL url, Storage storage) {
        return new FutureDwner(url, storage);
    }

    @Override
    public Downloader createFutureInsDwner(URL url, Storage storage) {
        return new FutureInsDwner(url, storage);
    }

    @Override
    public Downloader createOpInsDwner(URL url, Storage storage) {
        return new OpInsDwner(url, storage);
    }

    @Override
    public Downloader createFutureBigTraderOiDwner(URL url, Storage storage) {
        return new FutureBigTraderOiDwner(url, storage);
    }

    @Override
    public Downloader createOpBigTraderOiDwner(URL url, Storage storage) {
        return new OpBigTraderOiDwner(url, storage);
    }

    @Override
    public Downloader createTwseInsDwner(URL url, Storage storage) {
        return new TwseInsDwner(url, storage);
    }

    @Override
    public Downloader createCreditTransDwner(URL url, Storage storage) {
        return new CreditTransDwner(url, storage);
    }

    @Override
    public Downloader createBorrowSellDwner(URL url, Storage storage) {
        return new BorrowSellDwner(url, storage);
    }

    @Override
    public Downloader createTwseDwner(URL url, Storage storage) {
        return new TwseDwner(url, storage);
    }

    @Override
    public Downloader createTwseVolDwner(URL url, Storage storage) {
        return new TwseVolDwner(url, storage);
    }
}
