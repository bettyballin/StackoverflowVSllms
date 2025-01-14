import java.lang.String;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class SecureClient {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket("your.server.com", 443)) {

            // Start the handshake
            socket.startHandshake();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send some data securely
            out.println("Sensitive data");

            // Attempting to renegotiate and downgrade to clear text is not supported.
            // Instead, use a different connection for non-encrypted traffic or redesign your protocol.
        }
    }
}