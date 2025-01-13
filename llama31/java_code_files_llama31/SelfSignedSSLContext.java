/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class SelfSignedSSLContext {
    public static SSLContext getSSLContext() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, null);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagerArray = trustManagerFactory.getTrustManagers();
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerArray, null);
        return sSLContext;
    }

    public static void main(String[] stringArray) {
        try {
            SSLContext sSLContext = SelfSignedSSLContext.getSSLContext();
            System.out.println(sSLContext);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
