import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class SelfSignedTrustManager implements X509TrustManager {

    private final X509TrustManager originalTrustManager;

    public SelfSignedTrustManager(KeyStore keyStore) throws Exception {
        TrustManagerFactory originalTrustManagerFactory = TrustManagerFactory.getInstance("X509");
        originalTrustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = originalTrustManagerFactory.getTrustManagers();
        for (TrustManager trustManager : trustManagers) {
            if (trustManager instanceof X509TrustManager) {
                originalTrustManager = (X509TrustManager) trustManager;
                break;
            }
        }
        if (originalTrustManager == null) {
            throw new Exception("No X509TrustManager found");
        }
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        originalTrustManager.checkClientTrusted(chain, authType);
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        try {
            originalTrustManager.checkServerTrusted(chain, authType);
        } catch (CertificateException e) {
            // If the certificate is not trusted, check if it's your self-signed certificate
            if (chain != null && chain.length > 0) {
                // Get the self-signed certificate
                X509Certificate selfSignedCert = getSelfSignedCertificate();

                // Compare the server certificate with your self-signed certificate
                if (selfSignedCert.getPublicKey().equals(chain[0].getPublicKey())) {
                    // If they match, trust the server certificate
                    return;
                }
            }
            throw e;
        }
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return originalTrustManager.getAcceptedIssuers();
    }

    private X509Certificate getSelfSignedCertificate() {
        // Load your self-signed certificate (e.g., from resources or assets)
        // For demonstration purposes, this method returns null
        return null;
    }

    public static void main(String[] args) throws Exception {
        // Create a KeyStore instance
        KeyStore keyStore = KeyStore.getInstance("JKS");

        // Load the KeyStore instance
        keyStore.load(null, null);

        // Create a SelfSignedTrustManager instance
        SelfSignedTrustManager selfSignedTrustManager = new SelfSignedTrustManager(keyStore);

        // Use the selfSignedTrustManager instance as needed
    }
}