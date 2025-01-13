/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadFactory;

public class ThreadManager {
    private final ConcurrentMap<String, Thread> threads = new ConcurrentHashMap<String, Thread>();
    private final ThreadFactory threadFactory = runnable -> {
        Thread thread2 = new Thread(runnable);
        thread2.setUncaughtExceptionHandler((thread, throwable) -> {});
        return thread2;
    };

    public void startThread(String string, Runnable runnable) {
        Thread thread = this.threadFactory.newThread(runnable);
        thread.setName(string);
        thread.start();
        this.threads.put(string, thread);
    }

    public void stopThread(String string) {
        Thread thread = (Thread)this.threads.get(string);
        if (thread != null) {
            thread.interrupt();
        }
    }

    public boolean isThreadRunning(String string) {
        Thread thread = (Thread)this.threads.get(string);
        return thread != null && thread.isAlive();
    }

    public int getThreadCount() {
        return this.threads.size();
    }

    public static void main(String[] stringArray) {
    }
}
