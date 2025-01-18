import java.util.*;

public class OrderedDictionary<K, V> extends AbstractMap<K, V> {

    final Map<K, V> m;

    public OrderedDictionary() {
        m = getCleanCopy();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return m.entrySet();
    }

    @Override
    public V put(K key, V value) {
        return m.put(key, value);
    }

    Map<K, V> getCleanCopy() {
        // Implement this method to return a new instance of underlying map type:
        // For O(1) lookup and deletion operations, use HashMap:
        // return createHashMap();

        // Or choose the below one if ordered operations are required:
        return createLinkedHashMap();
    }

    Map<K, V> createHashMap() {
        return new HashMap<>(); // For O(1) lookup and deletion operations.
    }

    Map<K, V> createLinkedHashMap() {
        return new LinkedHashMap<>(); // Used to maintain insertion order.
    }

    public static void main(String[] args) {
        OrderedDictionary<String, Integer> dict = new OrderedDictionary<>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);

        for (Entry<String, Integer> entry : dict.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}