import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class QueueMap<K, V> {
    private final LinkedHashMap<K, V> map;

    public QueueMap(final int capacity) {
        this.map = new LinkedHashMap<K, V>(capacity + 1, 0.75F, true) { // accessOrder will make it an LRU cache
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public V get(K key) {
        return map.get(key);
    }

    // put() method is used to add elements into the queue and map both simultaneously.
    // If it's already there, replace its place according to access order in FIFO manner.
    public void put(K key, V value) {
        map.put(key, value);
    }

    // pollFirst() will return null if no values are present or remove the first element
    // based on insertion order if it's available.
    public V pollFirst() {
        if (map.isEmpty()) {
            return null;
        }
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        Map.Entry<K, V> entry = iterator.next();
        V value = entry.getValue();
        iterator.remove();
        return value;
    }

    public static void main(String[] args) {
        // You can add test cases here to test your QueueMap implementation
    }
}