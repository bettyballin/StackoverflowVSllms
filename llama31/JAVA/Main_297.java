import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.util.concurrent.LinkedBlockingQueue;

class ComponentSocketBasis {}

public class Main_297 {
    private LinkedBlockingQueue<Object[]> deferredPollQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.addElements();
        main.retrieveElements();
    }

    public void addElements() {
        SelectableChannel selectableChannel = null;
        ComponentSocketBasis componentSocketBasis = new ComponentSocketBasis();
        int integer = 0;

        // adding elements
        deferredPollQueue.add(new Object[] { selectableChannel, componentSocketBasis, integer });
    }

    public void retrieveElements() throws InterruptedException {
        // retrieving elements
        Object[] triplet = deferredPollQueue.take();
        SelectableChannel chan = (SelectableChannel) triplet[0];
        ComponentSocketBasis sock = (ComponentSocketBasis) triplet[1];
        int ops = (int) triplet[2];
    }
}