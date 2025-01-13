import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

public class CustomRMISocketFactory extends RMISocketFactory {
    private int minPort;
    private int maxPort;

    public CustomRMISocketFactory(int minPort, int maxPort) {
        this.minPort = minPort;
        this.maxPort = maxPort;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress(minPort));
        socket.connect(new InetSocketAddress(host, port));
        return socket;
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(minPort));
        return serverSocket;
    }

    public static void main(String[] args) {
    }
}