import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SelfSignedSSLContext {

    public static SSLContext getSSLContext() throws Exception {
        // Load your self-signed certificate (e.g., from resources or assets)

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        // Initialize the key store with your self-signed certificate
        keyStore.load(null, null); // You should load your keystore here

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);
        TrustManager[] trustManagers = tmf.getTrustManagers();

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, null);
        return sslContext;
    }

    public static void main(String[] args) {
        try {
            SSLContext sslContext = getSSLContext();
            System.out.println(sslContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}