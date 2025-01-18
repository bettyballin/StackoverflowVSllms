import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpGetter {
    public static void main(String[] args) throws Exception {
        // SSL Connection Factory for HTTPS connections
        System.setProperty("javax.net.ssl.trustStore", "path-to-store");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://www.verisign.com/");
        CloseableHttpResponse response = httpclient.execute(httpget);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line); // Print the fetched content
                }
            }
        } finally {
            response.close(); // closes both HttpResponse and underlying HttpConnection
            httpclient.close();
        }
    }
}