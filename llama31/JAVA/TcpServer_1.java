import java.io.IOException;
import java.net.ServerSocket;

public class TcpServer_1_1 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            // ...
        } catch (IOException e) {
            // handle exception
        }
    }
}