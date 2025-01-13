import java.net.Socket;
import java.net.StandardSocketOptions;

public class MulticastSocketConfigurator {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.setOption(StandardSocketOptions.IP_MULTICAST_IF, true);
    }
}