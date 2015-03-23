import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * User: Harvey
 * Date: 2015/3/4
 * Time: 上午 11:01
 */
public class Client {
    String url = "http://www.taifex.com.tw/chinese/3/dl_3_2_3_b.asp";
    String commodity = "TXO";
    String sDate = "2015/3/3";
    String eDate = "2015/3/4";

    public void execute(boolean oldVersion) throws IOException, URISyntaxException {
            newVersion();
    }

    private void newVersion() throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder();
        builder.setPath(url).addParameter("DATA_DATE", sDate).
                addParameter("DATA_DATE1", eDate).
                addParameter("datestart", sDate).
                addParameter("dateend", eDate).
                addParameter("COMMODITY_ID", commodity);
        HttpGet get = new HttpGet(builder.build().toString());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            long len = entity.getContentLength();
            boolean isStreaming = entity.isStreaming();
            InputStream inputStream = entity.getContent();
            showResult(inputStream);
        }
    }

    private void showResult(InputStream inputStream) throws IOException {
        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new InputStreamReader(inputStream, "Big5"));
            line = br.readLine();
            //start from second row
            while (line != null && line.length() > 0) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (br != null)
                br.close();
        }
    }

    public static void main(String arg[]) throws IOException, URISyntaxException {
        new Client().execute(false);
    }
}
