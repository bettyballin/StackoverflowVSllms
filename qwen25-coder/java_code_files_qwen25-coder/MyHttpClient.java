import java.net.URL;
import java.net.HttpsURLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class MyHttpClient {
    public static HttpsURLConnection getTrustingHttpsURLConnection(String url) throws Exception {
        HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();

        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        connection.setSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        connection.setHostnameVerifier((hostname, session) -> true);

        return connection;
    }

    public static void main(String[] args) {
    }
}