/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class Main_375 {
    public static void main(String[] stringArray) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream("path/to/truststore"), "password".toCharArray());
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
        SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
        Socket socket = sSLSocketFactory.createSocket("www.myserver.com", 443);
        socket.close();
    }
}
