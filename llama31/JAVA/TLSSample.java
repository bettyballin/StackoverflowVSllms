import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TLSSample {
    public static void main(String[] args) throws UnknownHostException, IOException {
        SSLContext sslContext = SSLContext.getDefault();
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(InetAddress.getByName("example.com"), 443);
        // Perform the TLS handshake
        sslSocket.startHandshake();
        // Use the secure socket to send and receive data
        sslSocket.getOutputStream().write("Hello, server!".getBytes());
        sslSocket.close();
    }
}