import java.lang.String;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DistanceVectorRoutingNode {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(PORT, InetAddress.getByName("127.0.0.1"));
        ExecutorService executor = Executors.newFixedThreadPool(5); // Adjust the pool size as necessary

        while (true) {
            try {
                byte[] buffer = new byte[2000];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                
                socket.receive(packet);
                
                // Submit the received packet to a thread for processing
                executor.submit(new PacketProcessor(socket, packet));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class PacketProcessor implements Runnable {
        private final DatagramSocket socket;
        private final DatagramPacket packet;

        public PacketProcessor(DatagramSocket socket, DatagramPacket packet) {
            this.socket = socket;
            this.packet = packet;
        }

        @Override
        public void run() {
            try {
                // Process the datagram packet here
                processDatagramPacket(packet);

                // Send routing information to all neighbors if necessary
                sendRoutingUpdates(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void processDatagramPacket(DatagramPacket packet) {
            // Your logic to process the packet goes here
            byte[] data = packet.getData();
            int length = packet.getLength();
            // Example: System.out.println("Received datagram: " + new String(data, 0, length));
        }

        private void sendRoutingUpdates(DatagramSocket socket) throws IOException {
            // Your logic to send routing updates goes here
        }
    }
}