import java.lang.String;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.KeyStore;

public class LocalTrustStore {
    public static void setupCustomSSLContext(String keystorePath, String keystorePassword) throws Exception {
        KeyStore trustStore = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream(keystorePath)) {
            trustStore.load(fis, keystorePassword.toCharArray());
        }

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), new java.security.SecureRandom());

        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }

    public static void main(String[] args) {
    }
}