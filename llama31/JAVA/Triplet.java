import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Define a placeholder class for ComponentSocketBasis
class ComponentSocketBasis {}

public class Triplet {
    public SelectableChannel channel;
    public ComponentSocketBasis socketBasis;
    public int ops;

    public Triplet(SelectableChannel channel, ComponentSocketBasis socketBasis, int ops) {
        this.channel = channel;
        this.socketBasis = socketBasis;
        this.ops = ops;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        // Initialize the queue
        BlockingQueue<Triplet> deferredPollQueue = new LinkedBlockingQueue<>();

        // Create placeholder objects for adding elements
        SelectableChannel selectableChannel = null; // Replace with actual channel creation
        ComponentSocketBasis componentSocketBasis = new ComponentSocketBasis();
        int integer = 0;

        // Adding elements
        deferredPollQueue.add(new Triplet(selectableChannel, componentSocketBasis, integer));

        // Retrieving elements
        Triplet triplet = deferredPollQueue.take();
        SelectableChannel chan = triplet.channel;
        ComponentSocketBasis sock = triplet.socketBasis;
        int ops = triplet.ops;

        // Print retrieved values (optional)
        System.out.println("Channel: " + chan);
        System.out.println("Socket Basis: " + sock);
        System.out.println("Ops: " + ops);
    }
}