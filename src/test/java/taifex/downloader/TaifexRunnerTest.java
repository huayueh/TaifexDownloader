package taifex.downloader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import taifex.storage.Storage;

import java.net.MalformedURLException;
import java.net.URL;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaifexRunnerTest {

    @Mock
    private Storage mockStorage;

    @Mock
    private DownloaderFactory mockDownloaderFactory;

    @Mock
    private Downloader mockOptionDwner;
    @Mock
    private Downloader mockFutureDwner;
    @Mock
    private Downloader mockFutureInsDwner;
    @Mock
    private Downloader mockOpInsDwner;
    @Mock
    private Downloader mockFutureBigTraderOiDwner;
    @Mock
    private Downloader mockOpBigTraderOiDwner;

    @Before
    public void setUp() throws MalformedURLException {
        // Configure the mock factory to return mock downloaders
        when(mockDownloaderFactory.createOptionDwner(any(URL.class), eq(mockStorage))).thenReturn(mockOptionDwner);
        when(mockDownloaderFactory.createFutureDwner(any(URL.class), eq(mockStorage))).thenReturn(mockFutureDwner);
        when(mockDownloaderFactory.createFutureInsDwner(any(URL.class), eq(mockStorage))).thenReturn(mockFutureInsDwner);
        when(mockDownloaderFactory.createOpInsDwner(any(URL.class), eq(mockStorage))).thenReturn(mockOpInsDwner);
        when(mockDownloaderFactory.createFutureBigTraderOiDwner(any(URL.class), eq(mockStorage))).thenReturn(mockFutureBigTraderOiDwner);
        when(mockDownloaderFactory.createOpBigTraderOiDwner(any(URL.class), eq(mockStorage))).thenReturn(mockOpBigTraderOiDwner);

        // Set the mock factory in TaifexRunner
        TaifexRunner.setDownloaderFactory(mockDownloaderFactory);
    }

    @Test
    public void testRunDownloads() {
        int year = 2023;
        int month = 10;
        int day = 26;

        TaifexRunner.runDownloads(mockStorage, year, month, day);

        // Verify interactions for OptionDwner
        verify(mockOptionDwner).setStart(year, month, 1);
        verify(mockOptionDwner).setEnd(year, month, day);
        verify(mockOptionDwner).download();

        // Verify interactions for FutureDwner
        verify(mockFutureDwner).setStart(year, month, 1);
        verify(mockFutureDwner).setEnd(year, month, day);
        verify(mockFutureDwner).download();

        // Verify interactions for FutureInsDwner
        verify(mockFutureInsDwner).setStart(year, month, 1);
        verify(mockFutureInsDwner).setEnd(year, month, day);
        verify(mockFutureInsDwner).download();

        // Verify interactions for OpInsDwner
        verify(mockOpInsDwner).setStart(year, month, 1);
        verify(mockOpInsDwner).setEnd(year, month, day);
        verify(mockOpInsDwner).download();

        // Verify interactions for FutureBigTraderOiDwner
        verify(mockFutureBigTraderOiDwner).setStart(year, month, 1);
        verify(mockFutureBigTraderOiDwner).setEnd(year, month, day);
        verify(mockFutureBigTraderOiDwner).download();

        // Verify interactions for OpBigTraderOiDwner
        verify(mockOpBigTraderOiDwner).setStart(year, month, 1);
        verify(mockOpBigTraderOiDwner).setEnd(year, month, day);
        verify(mockOpBigTraderOiDwner).download();
    }
}
