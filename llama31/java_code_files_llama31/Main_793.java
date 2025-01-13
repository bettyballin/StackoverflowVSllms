/*
 * Decompiled with CFR 0.152.
 */
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Main_793 {
    public static void main(String[] stringArray) throws Exception {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, null, null);
        SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
        SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket("your_server_address", 443);
    }
}
