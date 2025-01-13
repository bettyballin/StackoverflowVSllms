import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class CustomTrustStore {
    public static void main(String[] args) throws IOException, CertificateException {
        // Load the custom TrustStore
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream("custom-truststore.jks"), "password".toCharArray());

        // Create a TrustManagerFactory
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(trustStore);

        // Create an SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        // Use the custom SSLContext
        // ...
    }
}