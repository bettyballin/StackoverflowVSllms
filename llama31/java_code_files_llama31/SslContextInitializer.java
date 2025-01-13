/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class SslContextInitializer {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{new TrustAllCertificates()}, null);
    }
}
