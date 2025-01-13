import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMIServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;

public class SecureRMIRegistry {
    public static void main(String[] args) throws Exception {
        // Create an SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, null);

        // Create an SSL-protected RMI registry
        RMIServerSocketFactory socketFactory = new RMIServerSocketFactory() {
            public ServerSocket createServerSocket(int port) throws IOException {
                ServerSocket socket = new SSLServerSocket(0, 0, InetAddress.getByName("localhost"));
                socket.setNeedClientAuth(true);
                return socket;
            }
        };

        // Create the RMI registry
        LocateRegistry.createRegistry(1099, socketFactory);
    }
}