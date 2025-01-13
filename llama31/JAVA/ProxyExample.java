import java.lang.String;
import java.lang.Set;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ProxyExample {
    public static void main(String[] args) throws Exception {
        // Create a proxy instance
        HttpHost proxy = new HttpHost("myproxy.com", 9191);

        // Create a request config with the proxy
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

        // Create an HTTP client instance
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // Create an HTTP GET request
        HttpGet request = new HttpGet("http://example.com");

        // Set the request config on the request
        request.setConfig(config);

        // Execute the request
        CloseableHttpResponse response = httpClient.execute(request);

        // Print the response status code
        System.out.println(response.getStatusLine().getStatusCode());
    }
}