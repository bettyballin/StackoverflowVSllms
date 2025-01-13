/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Main_158 {
    public static void main(String[] stringArray) throws UnknownHostException, IOException {
        SSLSocketFactory sSLSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket(InetAddress.getByName("localhost"), 443);
        String[] stringArray2 = sSLSocket.getSupportedCipherSuites();
        sSLSocket.setEnabledCipherSuites(stringArray2);
    }
}
