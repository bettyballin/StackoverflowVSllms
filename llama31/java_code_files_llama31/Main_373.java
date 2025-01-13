/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Main_373 {
    public static void main(String[] stringArray) {
        String string = "your.server.host";
        int n = 443;
        SSLSocketFactory sSLSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        try {
            SSLSocket sSLSocket = (SSLSocket)sSLSocketFactory.createSocket(string, n);
        }
        catch (UnknownHostException unknownHostException) {
            System.err.println("Unknown host: " + string);
        }
        catch (IOException iOException) {
            System.err.println("I/O error: " + iOException.getMessage());
        }
    }
}
