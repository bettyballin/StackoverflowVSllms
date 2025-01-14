import java.lang.String;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleClientConnection(clientSocket);
        }
    }

    private static void handleClientConnection(Socket clientSocket) throws Exception {
        // Read data from the socket, normalize it, and store using JDO
        // Placeholder for actual data handling logic
    }
}