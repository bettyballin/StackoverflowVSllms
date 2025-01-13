/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

public class SSLChecker {
    public static void main(String[] stringArray) throws IOException {
        String string = "example.com";
        int n = 443;
        SSLSocketFactory sSLSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        Socket socket = sSLSocketFactory.createSocket(InetAddress.getByName(string), n);
        if (socket.isConnected()) {
            System.out.println("Server has SSL enabled");
        } else {
            System.out.println("Server does not have SSL enabled");
        }
    }
}
