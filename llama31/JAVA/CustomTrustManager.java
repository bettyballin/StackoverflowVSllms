import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CustomTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        // Add your self-assigned certificate to the trusted list
        // You can load it from a file or hardcode it
        // X509Certificate selfAssignedCert = ...; // You need to initialize this variable
        // chain[0].equals(selfAssignedCert);
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0]; // Return an empty array instead of null
    }

    public static void main(String[] args) {
        // Create a new instance of CustomTrustManager
        CustomTrustManager customTrustManager = new CustomTrustManager();

        // Create a new SSLContext
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { customTrustManager }, null);
        } catch (Exception e) {
            System.out.println("Error initializing SSLContext: " + e.getMessage());
        }
    }
}