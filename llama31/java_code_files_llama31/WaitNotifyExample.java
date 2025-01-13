/*
 * Decompiled with CFR 0.152.
 */
public class WaitNotifyExample {
    private static final Object lock = new Object();

    public static void main(String[] stringArray) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Object object = lock;
            synchronized (object) {
                try {
                    System.out.println("Thread 1: Waiting...");
                    lock.wait();
                    System.out.println("Thread 1: Notified!");
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            Object object = lock;
            synchronized (object) {
                System.out.println("Thread 2: Notifying...");
                lock.notify();
                System.out.println("Thread 2: Notified!");
            }
        });
        thread.start();
        Thread.sleep(1000L);
        thread2.start();
    }
}
