import java.net.ServerSocket;
import java.net.SocketException;

public class TcpServer {
    public static void main(String[] args) throws SocketException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.setReuseAddress(true);
    }
}