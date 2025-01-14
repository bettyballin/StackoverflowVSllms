import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastExample {
    public static void main(String[] args) {
        try {
            // Create a multicast socket on port 12345
            int port = 12345;
            String groupIP = "230.0.0.1";
            InetAddress address = InetAddress.getByName(groupIP);
            MulticastSocket socket = new MulticastSocket(port);

            // Set the TTL to a desired value, e.g., 64
            int ttl = 64;
            socket.setTimeToLive(ttl);

            // Create and send a datagram packet
            String message = "Hello, Multicast!";
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);

            System.out.println("Sent packet with TTL: " + ttl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}