import java.lang.String;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;

public class NetworkBroadcaster {
    private byte[] buffer = new byte[1024];
    private static final int PORT = 9999;
    private DatagramSocket socket;

    {
        try {
            InetAddress broadcastAddr = InetAddress.getByName("255.255.255.255");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, broadcastAddr, PORT);
            socket = new DatagramSocket();
            socket.send(packet); // Send to everyone on the network
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}