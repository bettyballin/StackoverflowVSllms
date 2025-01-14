import java.lang.String;
import java.util.concurrent.CountDownLatch;

public class ManualResetEventExample {
    private CountDownLatch latch = new CountDownLatch(1);

    public void reset() {
        // Reset the latch, reusing it if necessary
        synchronized (latch) {
            // Check if latch needs to be replaced because count is already 0
            if (latch.getCount() == 0) {
                latch = new CountDownLatch(1);
            }
        }
    }

    public void signal() {
        latch.countDown();
    }

    public void waitOne() throws InterruptedException {
        latch.await();
    }

    public static void main(String[] args) throws InterruptedException {
        ManualResetEventExample manualResetEvent = new ManualResetEventExample();

        Thread waitForSignalThread = new Thread(() -> {
            try {
                System.out.println("Waiting for signal...");
                manualResetEvent.waitOne();
                System.out.println("Received Signal!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        waitForSignalThread.start();

        // Simulate some work
        Thread.sleep(1000);

        // Signal the thread waiting
        manualResetEvent.signal();

        // Resetting the event for further use
        manualResetEvent.reset();
    }
}