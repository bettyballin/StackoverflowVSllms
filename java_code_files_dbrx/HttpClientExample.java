import java.lang.String;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientExample {
    public static void main(String[] args) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://targethost/resource");
        try (CloseableHttpResponse response = httpclient.execute(httpget)) {
            System.out.println(response.getStatusLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close(); // Always release the connection to prevent leakage
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}