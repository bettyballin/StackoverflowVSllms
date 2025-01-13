import java.util.*;

public class MagicalManyToOneMap<K, V> {
    private final Map<K, V> forward;
    private final Map<V, Set<K>> inverse;

    public MagicalManyToOneMap() {
        forward = new HashMap<>();
        inverse = new HashMap<>();
    }

    public V get(K key) {
        return forward.get(key);
    }

    public void put(K key, V value) {
        V oldValue = forward.get(key);
        if (oldValue != null) {
            inverse.get(oldValue).remove(key);
        }
        forward.put(key, value);
        inverse.computeIfAbsent(value, k -> new HashSet<>()).add(key);
    }

    public void remove(K key) {
        V value = forward.remove(key);
        if (value != null) {
            inverse.get(value).remove(key);
        }
    }

    public Set<K> getInverse(V value) {
        return inverse.get(value);
    }

    public Map<V, Set<K>> getInverseMap() {
        return inverse;
    }

    public static void main(String[] args) {
        MagicalManyToOneMap<String, String> map = new MagicalManyToOneMap<>();
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value2");
        
        System.out.println(map.get("key1")); // prints: value1
        System.out.println(map.getInverse("value1")); // prints: [key1, key2]
        System.out.println(map.getInverseMap()); // prints: {value1=[key1, key2], value2=[key3]}
    }
}