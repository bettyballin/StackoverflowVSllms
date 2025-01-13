import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

// Assuming ComponentSocketBasis is a custom class, 
// we'll create a basic implementation for demonstration purposes
class ComponentSocketBasis {
    // Add necessary fields and methods here
}

public class Main_294 {
    public static void main(String[] args) throws InterruptedException, IOException {
        LinkedBlockingQueue<List<Object>> deferredPollQueue = new LinkedBlockingQueue<>();

        // adding elements
        List<Object> triplet = new ArrayList<>();
        // Initialize the variables
        SelectableChannel selectableChannel = ServerSocketChannel.open();
        ((ServerSocketChannel) selectableChannel).bind(new InetSocketAddress(8000));
        ComponentSocketBasis componentSocketBasis = new ComponentSocketBasis();
        int integer = 0;
        triplet.add(selectableChannel);
        triplet.add(componentSocketBasis);
        triplet.add(integer);
        deferredPollQueue.add(triplet);

        // retrieving elements
        List<Object> retrievedTriplet = deferredPollQueue.take();
        SelectableChannel chan = (SelectableChannel) retrievedTriplet.get(0);
        ComponentSocketBasis sock = (ComponentSocketBasis) retrievedTriplet.get(1);
        int ops = (int) retrievedTriplet.get(2);

        // Close the channel to avoid resource leaks
        chan.close();
    }
}