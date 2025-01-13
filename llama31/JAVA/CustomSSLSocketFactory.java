import java.lang.String;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;

public class CustomSSLSocketFactory {
    private static final String TRUSTSTORE_TYPE = "JKS";
    private static final String TRUSTSTORE_PASSWORD = "changeit";

    public static SSLSocketFactory getSSLSocketFactory(String truststorePath, String truststorePassword) throws Exception {
        // Load the self-signed certificate
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(truststorePath);
        Certificate ca = cf.generateCertificate(fis);

        // Create a KeyStore containing our trusted CAs
        KeyStore keyStore = KeyStore.getInstance(TRUSTSTORE_TYPE);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("alias", ca);

        // Create a TrustManager that trusts the CAs in our KeyStore
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);
        X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];

        // Create a TrustManager that delegates to the default TrustManager for all certificates except the self-signed one
        TrustManager[] trustManagers = new TrustManager[]{new CustomTrustManager(defaultTrustManager, ca)};

        // Create an SSLContext that uses our TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagers, null);

        return sslContext.getSocketFactory();
    }

    private static class CustomTrustManager implements X509TrustManager {
        private final X509TrustManager defaultTrustManager;
        private final Certificate selfSignedCertificate;

        public CustomTrustManager(X509TrustManager defaultTrustManager, Certificate selfSignedCertificate) {
            this.defaultTrustManager = defaultTrustManager;
            this.selfSignedCertificate = selfSignedCertificate;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            defaultTrustManager.checkClientTrusted(chain, authType);
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            if (chain[0].equals(selfSignedCertificate)) {
                // Allow the self-signed certificate
                return;
            }
            defaultTrustManager.checkServerTrusted(chain, authType);
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return defaultTrustManager.getAcceptedIssuers();
        }
    }

	public static void main(String[] args) throws Exception {
		SSLSocketFactory sslSocketFactory = getSSLSocketFactory("path_to_your_truststore", TRUSTSTORE_PASSWORD);
		System.out.println(sslSocketFactory);
	}
}