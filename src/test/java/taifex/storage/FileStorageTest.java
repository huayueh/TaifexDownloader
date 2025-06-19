package taifex.storage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import taifex.downloader.Downloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FileStorageTest {

    private FileStorage fileStorage;
    private File tempDir;

    @Mock
    private Downloader mockDownloader;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Create a temporary directory for testing
        tempDir = new File(System.getProperty("java.io.tmpdir"), "fileStorageTest_" + System.currentTimeMillis());
        if (!tempDir.mkdirs()) {
            fail("Could not create temp directory: " + tempDir.getAbsolutePath());
        }
        fileStorage = new FileStorage(tempDir.getAbsolutePath());

        // Common mock setup
        when(mockDownloader.getName()).thenReturn("testDownloader");
        when(mockDownloader.getCurrentTime()).thenReturn(LocalDateTime.of(2023, 10, 26, 10, 0));
    }

    @After
    public void tearDown() throws IOException {
        // Clean up the temporary directory
        if (tempDir != null && tempDir.exists()) {
            FileUtils.deleteDirectory(tempDir);
        }
    }

    @Test
    public void testSaveInputStream_AppendFalse() throws IOException {
        String testData = "This is test data.";
        InputStream inputStream = IOUtils.toInputStream(testData, StandardCharsets.UTF_8);
        when(mockDownloader.append()).thenReturn(false);

        boolean result = fileStorage.save(inputStream, mockDownloader);
        assertTrue(result);

        File expectedFile = new File(tempDir, "testDownloader" + File.separator + "2023_10.csv");
        assertTrue(expectedFile.exists());
        assertEquals(testData, FileUtils.readFileToString(expectedFile, StandardCharsets.UTF_8));
    }

    @Test
    public void testSaveInputStream_AppendTrue() throws IOException {
        String initialData = "Initial data." + System.lineSeparator();
        String appendedData = "Appended data.";
        File targetFile = new File(tempDir, "testDownloader" + File.separator + "2023_10.csv");
        targetFile.getParentFile().mkdirs();
        FileUtils.writeStringToFile(targetFile, initialData, StandardCharsets.UTF_8, false);

        InputStream inputStream = IOUtils.toInputStream(appendedData, StandardCharsets.UTF_8);
        when(mockDownloader.append()).thenReturn(true);


        boolean result = fileStorage.save(inputStream, mockDownloader);
        assertTrue(result);

        assertTrue(targetFile.exists());
        String fileContent = FileUtils.readFileToString(targetFile, StandardCharsets.UTF_8);
        // Normalize line separators for comparison
        String expectedContent = (initialData + appendedData).replaceAll("\\r\\n|\\r|\\n", System.lineSeparator());
        assertEquals(expectedContent, fileContent.replaceAll("\\r\\n|\\r|\\n", System.lineSeparator()));
    }


    @Test
    public void testSaveLines_NewFile() throws IOException {
        List<String> lines = Arrays.asList("line1", "line2", "line3");
        String header = "HEADER" + System.lineSeparator();
        when(mockDownloader.append()).thenReturn(true); // save lines always implies append
        when(mockDownloader.getCsvHeader()).thenReturn(header);

        boolean result = fileStorage.save(lines, mockDownloader);
        assertTrue(result);

        File expectedFile = new File(tempDir, "testDownloader" + File.separator + "2023_10.csv");
        assertTrue(expectedFile.exists());
        String expectedContent = header + String.join(System.lineSeparator(), lines) + System.lineSeparator();
        assertEquals(expectedContent, FileUtils.readFileToString(expectedFile, StandardCharsets.UTF_8));
    }

    @Test
    public void testSaveLines_ExistingFile() throws IOException {
        String initialContent = "EXISTING_HEADER" + System.lineSeparator() + "existing_line" + System.lineSeparator();
        File targetFile = new File(tempDir, "testDownloader" + File.separator + "2023_10.csv");
        targetFile.getParentFile().mkdirs();
        FileUtils.writeStringToFile(targetFile, initialContent, StandardCharsets.UTF_8);

        List<String> newLines = Arrays.asList("newLine1", "newLine2");
        when(mockDownloader.append()).thenReturn(true); // save lines always implies append
        // getCsvHeader should not be called if file exists already with content

        boolean result = fileStorage.save(newLines, mockDownloader);
        assertTrue(result);

        String expectedContent = initialContent + String.join(System.lineSeparator(), newLines) + System.lineSeparator();
        assertEquals(expectedContent, FileUtils.readFileToString(targetFile, StandardCharsets.UTF_8));
    }

    @Test
    public void testGetLastDate_NotImplemented() {
        // This method is not implemented in FileStorage, so it should return null
        assertNull(fileStorage.getLastDate(mockDownloader));
    }
}
