/*
 * Decompiled with CFR 0.152.
 */
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

static class Main_224.1
implements X509TrustManager {
    Main_224.1() {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) {
    }
}
