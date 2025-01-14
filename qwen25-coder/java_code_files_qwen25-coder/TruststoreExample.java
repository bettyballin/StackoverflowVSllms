import javax.net.ssl.*;
import java.io.FileInputStream;
import java.security.KeyStore;

public class TruststoreExample {
    public static void main(String[] args) throws Exception {
        // Load the truststore containing the root CA certificate
        KeyStore trustStore = KeyStore.getInstance("JKS");
        FileInputStream fis = new FileInputStream("path/to/your/truststore.jks");
        trustStore.load(fis, "password".toCharArray());

        // Initialize a TrustManagerFactory with this keystore
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);

        // Set the default SSLSocketFactory to use the custom TrustManagers from the factory
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }
}