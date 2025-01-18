import java.io.*;
import java.net.*;

public class TCPServerConnectionHandler {
    // Sample code for TCP connection (Server)
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket socket = serverSocket.accept(); // accept client connections
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        }
    }
}