import java.net.*;
import java.io.*;

public class MulticastExample {
    public static void main(String[] args) throws IOException {
        int PORT = 12345; // Define the port number
        MulticastSocket socket = new MulticastSocket(PORT);

        InetAddress multicastGroup = InetAddress.getByName("225.0.0.1"); // For example
        socket.joinGroup(multicastGroup); // Join the group

        // ...

        // Assuming 'buffer' is defined and contains data to send
        byte[] buffer = "Hello, Multicast!".getBytes(); // Example buffer

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, multicastGroup, PORT);
        socket.send(packet); // Send to specific group only

        socket.leaveGroup(multicastGroup);
        socket.close();
    }
}