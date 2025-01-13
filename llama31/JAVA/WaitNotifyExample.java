import java.lang.String;
public class WaitNotifyExample {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1: Waiting...");
                    lock.wait();
                    System.out.println("Thread 1: Notified!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2: Notifying...");
                lock.notify();
                System.out.println("Thread 2: Notified!");
            }
        });

        thread1.start();
        Thread.sleep(1000); // Simulate some delay
        thread2.start();
    }
}