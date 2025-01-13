import java.util.concurrent.ConcurrentHashMap;

public class FileLocker_1_1 {
    private final ConcurrentHashMap<String, Object> fileLocks = new ConcurrentHashMap<>();

    public void restore(String from) throws Exception {
        Object lock = fileLocks.computeIfAbsent(from, k -> new Object());
        synchronized (lock) {
            // ...
        }
    }

    public static void main(String[] args) {
    }
}