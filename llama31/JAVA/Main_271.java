import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Main_271 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000); // replace with your port number
        serverSocket.setSoTimeout(10000); // 10 seconds
    }
}