import java.lang.String;
import java.net.ServerSocket;
import java.io.IOException;

public class ServerSocketConfiguration {
    ServerSocket serverSocket;
    int port = 0;

    {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setReuseAddress(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}