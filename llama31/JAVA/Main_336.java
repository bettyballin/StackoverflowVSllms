import java.net.Socket;
import java.net.SocketException;

public class Main_336 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.setKeepAlive(true);
        socket.setSoTimeout(30000); // 30 seconds
    }
}