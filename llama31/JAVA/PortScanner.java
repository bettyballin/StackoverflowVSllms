import java.lang.String;
import java.net.Socket;

public class PortScanner {
    public static void main(String[] args) {
        String host = "192.168.1.100"; // replace with the host IP
        int port = 1521; // Oracle's default port
        try {
            Socket socket = new Socket(host, port);
            System.out.println(host + " is listening on port " + port);
            socket.close();
        } catch (Exception e) {
            System.out.println(host + " is not listening on port " + port);
        }
    }
}