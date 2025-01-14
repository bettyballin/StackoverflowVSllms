import java.net.Socket;
import java.net.SocketException;

public class TCPSegmenter {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);

        // Set the send and receive buffer sizes
        socket.setSendBufferSize(8 * 1024); // e.g., 8KB
        socket.setReceiveBufferSize(8 * 1024);

        // Set TCP no-delay to influence Nagle's algorithm which affects segmentation
        socket.setTcpNoDelay(true);

        // Send data through the socket...
    }
}