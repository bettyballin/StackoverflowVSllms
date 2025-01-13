import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        // Create a connection pool
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(10); // Max connections
        cm.setDefaultMaxPerRoute(5); // Max connections per route

        // Create an HTTP client with the connection pool
        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build()) {

            // Create a request config with connection keep-alive
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000) // Socket timeout
                    .setConnectTimeout(5000) // Connect timeout
                    .setConnectionRequestTimeout(5000) // Connection request timeout
                    .build();

            // Use the HTTP client to make requests
            while (true) {
                HttpPost request = new HttpPost("http://example.com");
                request.setConfig(requestConfig);
                try (CloseableHttpResponse response = httpClient.execute(request)) {
                    // Process the response
                }
            }
        }
    }
}