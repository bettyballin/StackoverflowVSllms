import java.util.HashMap;
import java.util.Map;

public class BiMap<K, V> {
    private final Map<K, V> keyToValue = new HashMap<>();
    private final Map<V, K> valueToKey = new HashMap<>();

    public void put(K key, V value) {
        if (keyToValue.containsKey(key) || valueToKey.containsKey(value)) {
            throw new IllegalArgumentException("Duplicate keys or values are not allowed");
        }
        keyToValue.put(key, value);
        valueToKey.put(value, key);
    }

    public K getKey(V value) {
        return valueToKey.get(value);
    }

    public V getValue(K key) {
        return keyToValue.get(key);
    }

    public static void main(String[] args) {
    }
}