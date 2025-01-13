/*
 * Decompiled with CFR 0.152.
 */
public class ThreadIsolation {
    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void main(String[] stringArray) {
        Thread thread = new Thread(() -> {
            threadLocal.set("Thread 1");
            System.out.println(threadLocal.get());
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set("Thread 2");
            System.out.println(threadLocal.get());
        });
        thread.start();
        thread2.start();
    }
}
