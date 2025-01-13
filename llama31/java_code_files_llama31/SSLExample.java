/*
 * Decompiled with CFR 0.152.
 */
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLExample {
    public static void main(String[] stringArray) throws Exception {
        SSLContext sSLContext = SSLContext.getDefault();
        SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
        SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket("example.com", 443);
        sSLSocket.startHandshake();
        sSLSocket.close();
    }
}
