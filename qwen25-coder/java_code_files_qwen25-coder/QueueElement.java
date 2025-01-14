import java.nio.channels.SelectableChannel;

public class QueueElement {
    private final SelectableChannel channel;
    private final ComponentSocketBasis socketBasis;
    private final int ops;

    public QueueElement(SelectableChannel channel, ComponentSocketBasis socketBasis, int ops) {
        this.channel = channel;
        this.socketBasis = socketBasis;
        this.ops = ops;
    }

    public SelectableChannel getChannel() {
        return channel;
    }

    public ComponentSocketBasis getSocketBasis() {
        return socketBasis;
    }

    public int getOps() {
        return ops;
    }

    public static void main(String[] args) {
        // Example usage (optional)
    }
}

// Minimal definition of ComponentSocketBasis
class ComponentSocketBasis {
    // Add any necessary fields or methods if needed
}