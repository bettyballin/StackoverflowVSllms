/*
 * Decompiled with CFR 0.152.
 */
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

private static class CustomSSLSocketFactory.CustomTrustManager
implements X509TrustManager {
    private final X509TrustManager defaultTrustManager;
    private final Certificate selfSignedCertificate;

    public CustomSSLSocketFactory.CustomTrustManager(X509TrustManager x509TrustManager, Certificate certificate) {
        this.defaultTrustManager = x509TrustManager;
        this.selfSignedCertificate = certificate;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
        this.defaultTrustManager.checkClientTrusted(x509CertificateArray, string);
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
        if (x509CertificateArray[0].equals(this.selfSignedCertificate)) {
            return;
        }
        this.defaultTrustManager.checkServerTrusted(x509CertificateArray, string);
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return this.defaultTrustManager.getAcceptedIssuers();
    }
}
