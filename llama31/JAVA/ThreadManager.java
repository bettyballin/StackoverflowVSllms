import java.lang.String;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadManager {
    private final ConcurrentMap<String, Thread> threads;
    private final ThreadFactory threadFactory;

    public ThreadManager() {
        this.threads = new ConcurrentHashMap<>();
        this.threadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler((t, e) -> {
                // Handle uncaught exceptions
            });
            return thread;
        };
    }

    public void startThread(String name, Runnable task) {
        Thread thread = threadFactory.newThread(task);
        thread.setName(name);
        thread.start();
        threads.put(name, thread);
    }

    public void stopThread(String name) {
        Thread thread = threads.get(name);
        if (thread != null) {
            thread.interrupt();
        }
    }

    public boolean isThreadRunning(String name) {
        Thread thread = threads.get(name);
        return thread != null && thread.isAlive();
    }

    public int getThreadCount() {
        return threads.size();
    }

	public static void main(String[] args) {
	}
}