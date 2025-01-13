import java.io.IOException;
import java.net.ServerSocket;
import java.lang.Runtime;

public class ServerShutdownHook {
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8080); // initialize serverSocket
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // handle exception
                System.err.println("Error closing server socket: " + e.getMessage());
            }
        }));
    }
}