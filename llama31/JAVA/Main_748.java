import java.util.concurrent.CountDownLatch;

public class Main_748 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            System.out.println("Task 1 is running...");
            try {
                Thread.sleep(1000); // simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Task 2 is running...");
            try {
                Thread.sleep(2000); // simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            latch.countDown();
        });

        t1.start();
        t2.start();

        latch.await(); // block until both tasks are done

        System.out.println("Both tasks are done. Running task 3...");
        // task3
        System.out.println("Task 3 is running...");
    }
}