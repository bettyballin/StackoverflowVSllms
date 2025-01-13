import org.apache.http.HttpHost;

public class HttpClientConfig {
    HttpHost target = new HttpHost(ServiceWrapper.SERVER_HOST, ServiceWrapper.SERVER_PORT);

    public static void main(String[] args) {
    }
}

class ServiceWrapper {
    public static final String SERVER_HOST = "example.com";
    public static final int SERVER_PORT = 8080;
}