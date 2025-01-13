import java.util.Map;
import java.util.HashMap;

public class ThreadManager_1_1 {
    private Map<String, Thread> threads;

    public ThreadManager_1() {
        threads = new HashMap<>();
    }

    public void addThread(String name, Thread thread) {
        threads.put(name, thread);
    }

    public void killThread(String name) {
        Thread thread = threads.get(name);
        if (thread != null) {
            thread.interrupt();
        }
    }

    public static void main(String[] args) {
    }
}