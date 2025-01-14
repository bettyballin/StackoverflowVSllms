import java.lang.String;
import java.util.concurrent.CountDownLatch;

public class ParallelTasks {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2); // 2 because we are waiting for two tasks

        Thread t1 = new Thread(() -> {
            try {
                task1();
            } finally {
                latch.countDown(); // Decrease the countdown after task1 is done
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                task2();
            } finally {
                latch.countDown(); // Decrease the countdown after task2 is done
            }
        });

        t1.start();
        t2.start();

        try {
            latch.await(); // Main thread waits here until both tasks finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        task3(); // Execute task3 after both tasks are done
    }

    static void task1() {
        System.out.println("Executing Task 1");
        // Simulate work with sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void task2() {
        System.out.println("Executing Task 2");
        // Simulate work with sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void task3() {
        System.out.println("Executing Task 3 after Task 1 and Task 2 are done");
    }
}