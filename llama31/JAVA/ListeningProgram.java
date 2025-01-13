import java.lang.String;
import java.net.*;

public class ListeningProgram {
    public static void main(String[] args) throws Exception {
        int port = 8080; // Choose a port to listen on
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Listening on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Incoming connection from " + clientSocket.getInetAddress());
            // Handle the connection...
        }
    }
}