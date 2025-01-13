/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class SecureSocketConnector {
    public static void main(String[] stringArray) {
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            SSLSocket sSLSocket = (SSLSocket)sSLContext.getSocketFactory().createSocket("example.com", 443);
            SSLSession sSLSession = sSLSocket.getSession();
            sSLSession.invalidate();
            sSLSocket.startHandshake();
        }
        catch (UnknownHostException unknownHostException) {
            System.err.println("Unknown host: " + unknownHostException.getMessage());
        }
        catch (IOException iOException) {
            System.err.println("I/O error: " + iOException.getMessage());
        }
        catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
