import java.net.http.HttpClient;
import java.net.ProxySelector;
import java.net.InetSocketAddress;

public class ProxyHttpClientFactory {
    HttpClient client = HttpClient.newBuilder()
            .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 8080)))
            .build();

    public static void main(String[] args) {
    }
}