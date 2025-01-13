/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class SSLServer {
    public static void main(String[] stringArray) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("mykeystore.jks"), "mystorepass".toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, "mystorepass".toCharArray());
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(keyManagerFactory.getKeyManagers(), null, null);
        SSLServerSocketFactory sSLServerSocketFactory = sSLContext.getServerSocketFactory();
        SSLServerSocket sSLServerSocket = (SSLServerSocket)sSLServerSocketFactory.createServerSocket(8888);
        sSLServerSocket.setNeedClientAuth(true);
    }
}
