import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContexts;
import javax.net.ssl.SSLContext;

public class MyHttpClientBuilder {
    HttpClient httpClient;

    public MyHttpClientBuilder() throws Exception {
        // This SSLContext is the one that has your keystore or truststore added to it
        SSLContext sslContext = SSLContexts.createSystemDefault();
        SSLConnectionSocketFactory MySecurityHandler = new SSLConnectionSocketFactory(
                sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        httpClient = HttpClients.custom()
                .setHostnameVerifier(SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                .setSSLSocketFactory(MySecurityHandler).build();
    }

    public static void main(String[] args) throws Exception {
        new MyHttpClientBuilder();
    }
}