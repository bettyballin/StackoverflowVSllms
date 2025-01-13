import java.util.concurrent.ConcurrentHashMap;
import java.lang.String;
import java.util.concurrent.ThreadFactory;

public class ThreadIsolation_2_2 {
    private static ConcurrentHashMap<Thread, String> threadData = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            threadData.put(thread, "Thread-specific data");
            return thread;
        };

        Thread thread1 = threadFactory.newThread(() -> {
            System.out.println(threadData.get(Thread.currentThread()));
        });

        Thread thread2 = threadFactory.newThread(() -> {
            System.out.println(threadData.get(Thread.currentThread()));
        });

        thread1.start();
        thread2.start();
    }
}