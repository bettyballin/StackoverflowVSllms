import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.client.HttpClientBuilder;

public class ProxyHttpClientBuilder {

    public ProxyHttpClientBuilder() {
        String server = "example.com"; // Replace with actual server
        HttpHost targetHost = new HttpHost(server, 80, "http");
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(new HttpHost("localhost", 54321)); // proxy server info here instead of localhost (54321 is proxy port)
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setRoutePlanner(routePlanner);
        CloseableHttpClient httpClient = httpClientBuilder.build();
    }

    public static void main(String[] args) {
        new ProxyHttpClientBuilder();
    }
}