import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class SelfSignedHttpClient {

    public static HttpClient getHttpClient() throws Exception {
        // Create an SSLContext with your custom TrustManager
        SSLContext sslContext = SelfSignedSSLContext.getSSLContext();

        // Create an SSLSocketFactory using the custom SSLContext
        SSLSocketFactory sslSocketFactory = new SSLSocketFactory(sslContext, SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);

        // Create a SchemeRegistry with the custom SSLSocketFactory
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("https", sslSocketFactory, 443));

        // Create a ClientConnectionManager with the custom SchemeRegistry
        ClientConnectionManager clientConnectionManager = new DefaultHttpClient().getConnectionManager();
        clientConnectionManager.getSchemeRegistry().register(new Scheme("https", sslSocketFactory, 443));

        // Create an HttpClient with the custom ClientConnectionManager
        HttpClient httpClient = new DefaultHttpClient(clientConnectionManager);

        // Set the SSLContext for the HttpClient
        ((DefaultHttpClient) httpClient).setSslcontext(sslContext);

        return httpClient;
    }

    public static void main(String[] args) {
    }
}