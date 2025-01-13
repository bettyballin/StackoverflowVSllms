/*
 * Decompiled with CFR 0.152.
 */
public class ConcurrentExample {
    public static void main(String[] stringArray) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread 1: Running");
            System.out.println("Thread 1: Done");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: Running");
            System.out.println("Thread 2: Done");
        });
        thread.start();
        thread2.start();
    }
}
