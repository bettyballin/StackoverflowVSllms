import java.lang.String;
import java.net.*;
import java.io.*;

public class ClientDiscoverer {
    private static final String MULTICAST_ADDRESS = "224.0.0.1";
    private static final int MULTICAST_PORT = 12345;

    public static void main(String[] args) throws Exception {
        // Create a multicast socket
        MulticastSocket socket = new MulticastSocket(MULTICAST_PORT);
        socket.joinGroup(InetAddress.getByName(MULTICAST_ADDRESS));

        // Send a multicast packet
        byte[] data = "Hello, clients!".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName(MULTICAST_ADDRESS), MULTICAST_PORT);
        socket.send(packet);

        // Listen for responses
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);

            // Get the client's IP address and port
            InetAddress clientAddress = response.getAddress();
            int clientPort = response.getPort();

            System.out.println("Client discovered: " + clientAddress.getHostAddress() + ":" + clientPort);
        }
    }
}