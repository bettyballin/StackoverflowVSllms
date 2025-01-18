import java.lang.String;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class TrustCert {
    public void requestWithCustomCert() throws Exception {
        URL url = new URL("https://yourserver.com");
        KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
        truststore.load(null, null); // Use an empty truststore

        TrustManager[] trustmanagers = new TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}

            public void checkServerTrusted(X509Certificate[] certs, String authType) {}

            public X509Certificate[] getAcceptedIssuers() {return null;}
        }};

        KeyManager[] keymanagers = null; // We don't need any client certificate...

        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(keymanagers, trustmanagers, null); // No need for randomness

        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setSSLSocketFactory(sslcontext.getSocketFactory());

        InputStream inputstream = conn.getInputStream();
        // Handle the response here...
    }

    public static void main(String[] args) {
    }
}