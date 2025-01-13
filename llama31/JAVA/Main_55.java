import java.util.concurrent.ConcurrentHashMap;

public class Main_55 {
    private final ConcurrentHashMap<Integer, Object> locks = new ConcurrentHashMap<>();

    public void retrieveAndStore(int id) {
        synchronized (locks.computeIfAbsent(id, k -> new Object())) {
            // retrieve, store
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.retrieveAndStore(1);
    }
}