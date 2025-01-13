import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpConnectionManager {

    public static void main(String[] args) {
        TcpConnectionManager manager = new TcpConnectionManager();
        manager.connectToServer();
    }

    public void connectToServer() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8000);
            if (socket.isConnected()) {
                System.out.println("The connection is active");
            } else {
                System.out.println("The connection is not active");
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
            }
        }
    }
}