import java.lang.String;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestRaceCondition {
    private static final int THREADS = 2;
    private static CyclicBarrier barrier = new CyclicBarrier(THREADS);
    private static AtomicBoolean success = new AtomicBoolean(true);

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            try {
                // Do some work
                System.out.println("Thread 1 working...");
                Thread.sleep(50); // Simulate work with sleep

                barrier.await(); // Wait for other threads

                // Further operations that may lead to race condition if ordering is not considered
                System.out.println("Thread 1 done awaiting");
            } catch (Exception e) {
                success.set(false);
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                // Do some other work
                System.out.println("Thread 2 working...");
                Thread.sleep(30); // Simulate work with sleep

                barrier.await(); // Wait for other threads

                // Further operations that may lead to race condition if ordering is not considered
                System.out.println("Thread 2 done awaiting");
            } catch (Exception e) {
                success.set(false);
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        if (success.get()) {
            System.out.println("Race condition test passed.");
        } else {
            System.out.println("Race condition detected!");
        }
    }
}