/*
 * Decompiled with CFR 0.152.
 */
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

static class SSLInitializer.TrustAllCertificates
implements TrustManager,
X509TrustManager {
    SSLInitializer.TrustAllCertificates() {
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
