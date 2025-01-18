import java.io.IOException;
import java.net.*;

public class CheckPort {
    public static void main(String[] args) throws Exception {
        String hostname = "example.com"; // replace with actual IP address or host name
        int port = 1521;
        Socket socket = new Socket();
        try {
            SocketAddress sockaddr = new InetSocketAddress(hostname, port);
            socket.connect(sockaddr, 3000); // 3000 milliseconds timeout
            System.out.println("Connected");
        } catch (IOException e) {
            System.err.print("Connection failed");
        } finally {
            if (!socket.isClosed()) socket.close();
        }
    }
}