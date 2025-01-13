import java.net.SocketException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.channels.StandardSocketOptions;

public class PacketSender {
    public static void main(String[] args) {
        try (SocketChannel socket = SocketChannel.open(StandardProtocolFamily.INET)) {
            // Send data using socket.write()
        } catch (SocketException e) {
            if (e.getMessage().contains("ICMP Dest Unreachable")) {
                // Handle permanent packet delivery failure
            }
        } catch (Exception e) {
            // Handle other exceptions
        }
    }
}