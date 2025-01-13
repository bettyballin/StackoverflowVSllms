/*
 * Decompiled with CFR 0.152.
 */
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CustomTrustManager
implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public static void main(String[] stringArray) {
        CustomTrustManager customTrustManager = new CustomTrustManager();
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{customTrustManager}, null);
        }
        catch (Exception exception) {
            System.out.println("Error initializing SSLContext: " + exception.getMessage());
        }
    }
}
