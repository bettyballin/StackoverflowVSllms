import java.lang.String;
public class ThreadIsolation {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Thread 1");
            System.out.println(threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Thread 2");
            System.out.println(threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}