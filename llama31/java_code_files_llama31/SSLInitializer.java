/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSLInitializer {
    public static void main(String[] stringArray) throws Exception {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        TrustManager[] trustManagerArray = new TrustManager[]{new TrustAllCertificates()};
        sSLContext.init(null, trustManagerArray, new SecureRandom());
        SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
    }

    static class TrustAllCertificates
    implements TrustManager,
    X509TrustManager {
        TrustAllCertificates() {
        }

        @Override
        public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
