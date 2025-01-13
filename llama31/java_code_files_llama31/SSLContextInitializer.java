/*
 * Decompiled with CFR 0.152.
 */
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class SSLContextInitializer {
    public static void main(String[] stringArray) throws Exception {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, null, null);
        SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
        SSLContext.setDefault(sSLContext);
    }
}
