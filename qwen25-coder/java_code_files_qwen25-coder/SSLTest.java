import java.lang.String;
import javax.net.ssl.*;
import java.io.*;

public class SSLTest {
    public static void main(String[] args) {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) factory.createSocket("example.com", 443)) {
            socket.startHandshake(); // Initiates handshake
            System.out.println("Connection established with " + socket.getSession().getProtocol() +
                    " and " + socket.getSession().getCipherSuite());
        } catch (IOException e) {
            System.err.println("Error connecting: " + e.getMessage());
        }
    }
}