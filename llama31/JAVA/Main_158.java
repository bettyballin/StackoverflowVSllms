import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main_158 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Create an SSLSocket object
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(InetAddress.getByName("localhost"), 443);

        // Get the default enabled cipher suites
        String[] enabledCipherSuites = socket.getSupportedCipherSuites();

        // Set the enabled cipher suites
        socket.setEnabledCipherSuites(enabledCipherSuites);
    }
}