// Subscriber.java: This is the client receiving messages.

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Subscriber {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()) {
            // Socket to talk to server
            ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
            subscriber.connect("tcp://localhost:5556");

            // Any messages are welcome
            subscriber.subscribe(ZMQ.SUBSCRIPTION_ALL);

            while (!Thread.currentThread().isInterrupted()) {
                String receivedGraphData = new String(subscriber.recv());
                System.out.println("Received Graph Data: " + receivedGraphData);
                // Process the data here (e.g., load it into memory for your algorithms)
            }
        } catch (Exception e) {
            System.err.println("Subscriber error: " + e.getMessage());
        }
    }
}