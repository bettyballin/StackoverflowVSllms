import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main_586 {
    public static void main(String[] args) throws IOException {
        java.io.PrintStream out = System.out;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://www.example.com");
        CloseableHttpResponse response = httpClient.execute(request);
        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity());
                out.println(content);
            } else {
                out.println("Failed to retrieve content");
            }
        } finally {
            response.close();
            httpClient.close();
        }
    }
}