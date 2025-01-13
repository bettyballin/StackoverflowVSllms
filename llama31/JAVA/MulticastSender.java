import java.net.DatagramPacket;
import java.net.Inet6Address;
import java.net.MulticastSocket;
import java.net.SocketOptions;

public class MulticastSender {
    public static void main(String[] args) throws Exception {
        MulticastSocket socket = new MulticastSocket();
        String data = "Hello, world!";
        byte[] bytes = data.getBytes();
        String address = "224.0.0.1"; // replace with your multicast address
        int port = 5000; // replace with your port
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, java.net.InetAddress.getByName(address), port);

        // Set TTL for IPv4
        packet.setTTL((byte) 10);

        // Set Hop Limit for IPv6
        if (java.net.InetAddress.getByName(address) instanceof Inet6Address) {
            socket.setOption(SocketOptions.IP_MULTICAST_HOPS, 10);
        }

        socket.send(packet);
        socket.close();
    }
}