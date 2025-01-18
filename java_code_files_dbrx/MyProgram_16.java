import java.util.concurrent.*;

public class MyProgram {
    public static void main(String[] args) throws InterruptedException {
        // declare the latch
        final CountDownLatch doneLatch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            // task 1 code
            // count down on completion of task 1
            doneLatch.countDown();
        });

        Thread t2 = new Thread(() -> {
            // task 2 code
            // count down on completion of task 2
            doneLatch.countDown();
        });

        t1.start();
        t2.start();

        // the next line will block until both threads have completed, allowing both tasks to be parallelized
        doneLatch.await();

        // once await() returns without exception, it indicates that count has reached zero and task3 can start safely.
    }
}