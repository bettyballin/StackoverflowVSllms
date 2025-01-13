import java.util.LinkedHashMap;
import java.util.Map;

public class BoundedQueue<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public BoundedQueue(int maxSize) {
        super(maxSize, 0.75f, true); // true for access order
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }

    public void add(K key, V value) {
        put(key, value);
    }

    public static void main(String[] args) {
        // Example usage:
        BoundedQueue<String, String> queue = new BoundedQueue<>(3);
        queue.add("key1", "value1");
        queue.add("key2", "value2");
        queue.add("key3", "value3");
        queue.add("key4", "value4"); // This should remove the eldest entry
        System.out.println(queue);
    }
}