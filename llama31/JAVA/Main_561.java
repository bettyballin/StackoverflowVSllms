import java.net.Socket;
import java.net.SocketException;

public class Main_561 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.setReceiveBufferSize(1024 * 1024); // Increase receive buffer size
            socket.setSendBufferSize(1024 * 1024); // Increase send buffer size
        } catch (SocketException e) {
            System.out.println("SocketException caught: " + e.getMessage());
        }
    }
}