// Publisher.java: This is the server sending messages (your graph data).

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import java.nio.ByteBuffer;

public class Publisher {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {
            // Socket to talk to clients
            var publisher = context.createSocket(SocketType.PUB);
            publisher.bind("tcp://*:5556");

            // Prepare some data to send (simulate your graph)
            String graphData = "YourSerializedGraphData";

            while (!Thread.currentThread().isInterrupted()) {
                publisher.send(graphData.getBytes());
                Thread.sleep(1000); // Send data every second
            }
        } catch (Exception e) {
            System.err.println("Publisher error: " + e.getMessage());
        }
    }
}