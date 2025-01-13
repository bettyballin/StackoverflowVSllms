import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketFactory;

public class CustomSocketFactory {
    static {
        System.setProperty("java.net.bindAddress", "192.168.1.100"); // replace with the IP address mapped in IIS
    }

    public static void main(String[] args) throws IOException {
        SocketFactory factory = new SocketFactory() {
            public Socket createSocket() throws IOException {
                Socket socket = new Socket();
                socket.bind(new InetSocketAddress("192.168.1.100", 0)); // replace with the IP address mapped in IIS
                return socket;
            }
        };
        factory.createSocket();
    }
}