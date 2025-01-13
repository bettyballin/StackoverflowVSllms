import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class SSLWebServiceClient {
    public static void main(String[] args) throws Exception {
        // Create a custom TrustManager that trusts all certificates
        TrustManager[] trustManagers = new TrustManager[] {
            new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    // Do nothing
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    // Do nothing
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }
        };

        // Create an SSLContext with the custom TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, new SecureRandom());

        // Create an HttpsURLConnection with the SSLContext
        URL url = new URL("https://example.com/webservice");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(sslContext.getSocketFactory());

        // Call the web service
        connection.connect();
        System.out.println("Connected to the web service.");
    }
}