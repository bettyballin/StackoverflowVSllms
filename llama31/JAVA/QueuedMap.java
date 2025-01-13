import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QueuedMap<K, V> {
    private final Deque<V> queue = new LinkedList<>();
    private final Map<K, V> map = new HashMap<>();
    private final Map<V, K> reverseMap = new HashMap<>();

    public void add(K key, V value) {
        queue.add(value);
        map.put(key, value);
        reverseMap.put(value, key);
    }

    public V remove() {
        V value = queue.poll();
        if (value != null) {
            map.remove(reverseMap.get(value));
            reverseMap.remove(value);
        }
        return value;
    }

    public V get(K key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        QueuedMap<String, Integer> queuedMap = new QueuedMap<>();
        queuedMap.add("apple", 5);
        queuedMap.add("banana", 7);
        System.out.println(queuedMap.remove()); // prints 5
        System.out.println(queuedMap.get("banana")); // prints 7
    }
}