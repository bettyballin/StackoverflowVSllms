import java.lang.String;
import java.net.*;
import java.io.*;

public class Client {
    private static final String MULTICAST_ADDRESS = "224.0.0.1";
    private static final int MULTICAST_PORT = 12345;

    public static void main(String[] args) throws Exception {
        // Create a multicast socket
        MulticastSocket socket = new MulticastSocket(MULTICAST_PORT);
        socket.joinGroup(InetAddress.getByName(MULTICAST_ADDRESS));

        // Listen for multicast packets
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            // Check if it's the discovery packet
            if (new String(packet.getData()).equals("Hello, clients!")) {
                // Respond with our IP address and port
                byte[] data = ("Hello, server!").getBytes();
                DatagramPacket response = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
                socket.send(response);
            }
        }
    }
}