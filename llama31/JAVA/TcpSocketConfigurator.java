import java.net.Socket;
import java.net.StandardSocketOptions;

public class TcpSocketConfigurator {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.setOption(StandardSocketOptions.IP_TOS, 0);
        // Java doesn't support setting TCP checksum offload directly.
        // However, it is usually offloaded by default on most systems.
        // The line below is commented out, but would look something like this:
        // socket.setOption(StandardSocketOptions.SO_TCP_CHECKSUM_OFFLOAD, false);
        // Java doesn't support this, we just don't throw an exception.
    }
}