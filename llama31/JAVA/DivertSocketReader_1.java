import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class DivertSocketReader_1_1 {
    public static void main(String[] args) throws Exception {
        // Create a datagram socket
        DatagramSocket socket = new DatagramSocket(1234); // replace with the actual port

        // Create a buffer to read the packet data
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        try {
            while (true) {
                // Read data from the socket
                socket.receive(packet);

                // Get the packet data
                byte[] packetData = packet.getData();

                // Process the packet data
                processPacket(packetData);
            }
        } finally {
            socket.close();
        }
    }

    private static void processPacket(byte[] packetData) {
        // TO DO: implement your packet processing logic here
    }
}