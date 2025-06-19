# TAIFEX and TWSE Data Downloader

## 1. Project Overview

This Java application downloads financial data from the Taiwan Futures Exchange (TAIFEX) and Taiwan Stock Exchange (TWSE). It provides runners for fetching different datasets and stores them in CSV files.

## 2. Prerequisites

To build and run this project, you need the following:

*   Java 21 JDK
*   Apache Maven

## 3. Building the Project

To build the project, navigate to the project root directory and run the following Maven command:

```bash
mvn clean package
```

This command will compile the source code, run tests, and package the application into a JAR file in the `target` directory. It also copies necessary runtime dependencies into `target/lib`.

## 4. Running the Application

The application provides two main runners: `TaifexRunner` and `TwseRunner`.

### Running `TaifexRunner`

`TaifexRunner` downloads various datasets from TAIFEX.

**Command-line arguments:**

*   `YYYY`: The year for which to download data.
*   `MM`: The month for which to download data.
*   `DD`: The day up to which data should be downloaded for the specified month.

**Example:**

To download TAIFEX data for October 26, 2023:

```bash
java -cp target/taifex-downloader-1.0-SNAPSHOT.jar:target/lib/* taifex.downloader.TaifexRunner 2023 10 26
```

(Note: On Windows, use a semicolon `;` instead of a colon `:` to separate paths in the classpath)

```bash
java -cp target\taifex-downloader-1.0-SNAPSHOT.jar;target\lib\* taifex.downloader.TaifexRunner 2023 10 26
```

### Running `TwseRunner`

`TwseRunner` downloads various datasets from TWSE.

**Command-line arguments:**

*   `YYYY`: The year for which to download data.
*   `MM`: The month for which to download data.
*   `DD`: The day up to which data should be downloaded for the specified month.

**Example:**

To download TWSE data for October 26, 2023:

```bash
java -cp target/taifex-downloader-1.0-SNAPSHOT.jar:target/lib/* taifex.downloader.TwseRunner 2023 10 26
```
(or for Windows)
```bash
java -cp target\taifex-downloader-1.0-SNAPSHOT.jar;target\lib\* taifex.downloader.TwseRunner 2023 10 26
```

Downloaded data will be stored in the `target/Taifex` and `target/Twse` directories respectively, organized by year and month.

## 5. Project Structure

*   **`taifex.downloader`**: Contains the main runner classes (`TaifexRunner`, `TwseRunner`) and various `Downloader` implementations for specific datasets from TAIFEX and TWSE. It also includes a `DownloaderFactory` for creating downloader instances.
*   **`taifex.storage`**: Provides interfaces and implementations for data persistence. `FileStorage` is the current implementation, saving data to local CSV files.
*   **`taifex.model.entity`**: Contains Java classes representing the structure of the downloaded data (though these are currently not fully utilized by the file storage mechanism).

## 6. Dependencies

The project uses the following major dependencies:

*   **Log4j 2**: Logging framework (version 2.25.0)
    *   `log4j-slf4j-impl`
    *   `log4j-core`
*   **LMAX Disruptor**: High-performance inter-thread messaging library (version 4.0.0)
*   **Apache Commons Lang3**: Utilities for common language operations (version 3.17.0)
*   **Apache Commons IO**: Utilities for I/O operations (version 2.19.0)
*   **Apache HttpClient**: HTTP client library (version 4.5.14)
*   **JSON**: Library for working with JSON data (version 20250517)
*   **JUnit**: Testing framework (version 4.13.2, for test scope)
*   **Mockito**: Mocking framework for unit tests (version 4.6.1, for test scope)

The project is built with Maven and requires Java 21. Maven plugins used include:
* `maven-compiler-plugin` (version 3.14.0)
* `maven-dependency-plugin` (version 3.8.1)
* `maven-clean-plugin`
* `maven-resources-plugin`
* `maven-surefire-plugin`
