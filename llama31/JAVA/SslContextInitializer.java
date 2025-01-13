import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class SslContextInitializer {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new TrustAllCertificates()}, null);
    }
}

class TrustAllCertificates implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
    @Override
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) {
    }

    @Override
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) {
    }

    @Override
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[0];
    }
}