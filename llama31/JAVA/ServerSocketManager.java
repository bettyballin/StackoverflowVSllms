import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketManager {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            // ...
        } catch (IOException e) {
            // handle exception
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    // handle exception
                }
            }
        }
    }
}