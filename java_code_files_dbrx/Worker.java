import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {
    private final BlockingQueue<Runnable> queue;

    public Worker(BlockingQueue<Runnable> q) {
        queue = q; // constructor initializes blocking queue as a member property of the class
    }

    @Override
    public void run() {
        try {
            while (true) // loop until executor shuts down or task ends naturally
                queue.take().run(); // remove a work item and execute it, waits if necessary for an available job
        } catch (InterruptedException ex) {
            /*...*/
        }
    }

    public static void main(String[] args) {
    }
}