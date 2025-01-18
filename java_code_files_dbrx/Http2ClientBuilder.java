import javax.net.ssl.SSLContext;

public class Http2ClientBuilder {

    SSLContext sslContext;
    String[] ALPN_NAMES = { "h2", "http/1.1" };
    SslConnectionFactory connectionFactory;
    HttpClient httpClient;

    public Http2ClientBuilder() {
        try {
            sslContext = SSLContext.getDefault();
        } catch (Exception e) {
            e.printStackTrace();
        }
        connectionFactory = new SslConnectionFactory(sslContext, ALPN_NAMES);
        httpClient = new HttpClient(new HttpClientTransportOverHTTP2(connectionFactory));
        // more configurations and usages of 'httpClient' here...
    }

    public static void main(String[] args) {
        new Http2ClientBuilder();
    }
}

class SslConnectionFactory {
    public SslConnectionFactory(SSLContext context, String[] alpnNames) {
        // Minimal constructor
    }
}

class HttpClientTransportOverHTTP2 {
    public HttpClientTransportOverHTTP2(SslConnectionFactory connectionFactory) {
        // Minimal constructor
    }
}

class HttpClient {
    public HttpClient(HttpClientTransportOverHTTP2 transportOverHTTP2) {
        // Minimal constructor
    }
}