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
public class TwseRunnerTest {

    @Mock
    private Storage mockStorage;

    @Mock
    private DownloaderFactory mockDownloaderFactory;

    @Mock
    private Downloader mockTwseInsDwner;
    @Mock
    private Downloader mockCreditTransDwner;
    @Mock
    private Downloader mockBorrowSellDwner;
    @Mock
    private Downloader mockTwseDwner;
    @Mock
    private Downloader mockTwseVolDwner;

    @Before
    public void setUp() throws MalformedURLException {
        // Configure the mock factory to return mock downloaders
        when(mockDownloaderFactory.createTwseInsDwner(any(URL.class), eq(mockStorage))).thenReturn(mockTwseInsDwner);
        when(mockDownloaderFactory.createCreditTransDwner(any(URL.class), eq(mockStorage))).thenReturn(mockCreditTransDwner);
        when(mockDownloaderFactory.createBorrowSellDwner(any(URL.class), eq(mockStorage))).thenReturn(mockBorrowSellDwner);
        when(mockDownloaderFactory.createTwseDwner(any(URL.class), eq(mockStorage))).thenReturn(mockTwseDwner);
        when(mockDownloaderFactory.createTwseVolDwner(any(URL.class), eq(mockStorage))).thenReturn(mockTwseVolDwner);

        // Set the mock factory in TwseRunner
        TwseRunner.setDownloaderFactory(mockDownloaderFactory);
    }

    @Test
    public void testRunDownloads() {
        int year = 2023;
        int month = 10;
        int day = 26;

        TwseRunner.runDownloads(mockStorage, year, month, day);

        // Verify interactions for TwseInsDwner
        verify(mockTwseInsDwner).setStart(year, month, 1);
        verify(mockTwseInsDwner).setEnd(year, month, day);
        verify(mockTwseInsDwner).download();

        // Verify interactions for CreditTransDwner
        verify(mockCreditTransDwner).setStart(year, month, 1);
        verify(mockCreditTransDwner).setEnd(year, month, day);
        verify(mockCreditTransDwner).download();

        // Verify interactions for BorrowSellDwner
        verify(mockBorrowSellDwner).setStart(year, month, 1);
        verify(mockBorrowSellDwner).setEnd(year, month, day);
        verify(mockBorrowSellDwner).download();

        // Verify interactions for TwseDwner
        verify(mockTwseDwner).setStart(year, month, 1);
        verify(mockTwseDwner).setEnd(year, month, day);
        verify(mockTwseDwner).download();

        // Verify interactions for TwseVolDwner
        verify(mockTwseVolDwner).setStart(year, month, 1);
        verify(mockTwseVolDwner).setEnd(year, month, day);
        verify(mockTwseVolDwner).download();
    }
}
