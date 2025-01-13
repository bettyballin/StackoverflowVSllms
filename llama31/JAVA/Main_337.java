import java.net.Socket;
import java.net.SocketException;

public class Main_337 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.setTcpNoDelay(true);
        socket.setReceiveBufferSize(1024 * 1024); // 1MB
        socket.setSendBufferSize(1024 * 1024); // 1MB
    }
}