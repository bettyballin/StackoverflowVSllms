import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DistanceVectorRouting {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(4445, InetAddress.getByName("127.0.0.1"));
        ExecutorService executor = Executors.newFixedThreadPool(10); // Adjust the pool size as needed

        while (true) {
            try {
                byte[] buf = new byte[2000];
                DatagramPacket recvRequest = new DatagramPacket(buf, buf.length);
                socket.receive(recvRequest);

                // Submit the processing task to the executor
                executor.submit(new DatagramProcessor(recvRequest));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class DatagramProcessor implements Runnable {
    private DatagramPacket packet;

    public DatagramProcessor(DatagramPacket packet) {
        this.packet = packet;
    }

    @Override
    public void run() {
        // Process the datagram here
        // Some process of data in datagram
    }
}