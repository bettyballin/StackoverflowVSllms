/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.CountDownLatch;

public class Main_748 {
    public static void main(String[] stringArray) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread = new Thread(() -> {
            System.out.println("Task 1 is running...");
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            countDownLatch.countDown();
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("Task 2 is running...");
            try {
                Thread.sleep(2000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
            countDownLatch.countDown();
        });
        thread.start();
        thread2.start();
        countDownLatch.await();
        System.out.println("Both tasks are done. Running task 3...");
        System.out.println("Task 3 is running...");
    }
}
