import java.util.concurrent.LinkedBlockingQueue;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class SocketChannelProcessor {
    public static void main(String[] args) {
        LinkedBlockingQueue<Object[]> deferredPollQueue = new LinkedBlockingQueue<>();

        // Assume 'channel', 'sock', and 'ops' are defined elsewhere
        SelectableChannel channel = null; // Placeholder
        Object sock = null; // Placeholder
        Integer ops = 0; // Placeholder

        deferredPollQueue.offer(new Object[]{channel, sock, ops});

        // Assume 'selector' is defined elsewhere
        Selector selector = null; // Placeholder

        while (!deferredPollQueue.isEmpty()) {
            System.out.println("*** Draining new socket channel from queue");
            Object[] element = deferredPollQueue.poll();
            SelectionKey k = ((SelectableChannel) element[0]).register(selector, (Integer) element[2]);
            // Rest of the code
        }
    }
}