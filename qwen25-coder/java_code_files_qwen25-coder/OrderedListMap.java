import java.util.*;
import java.util.function.Consumer;

public class OrderedListMap<K, V> {
    private final LinkedHashMap<K, V> map = new LinkedHashMap<>();

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public Collection<V> values() {
        return map.values();
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    // Method to iterate over the entries in insertion order
    public void forEachValue(Consumer<V> action) {
        for (V value : map.values()) {
            action.accept(value);
        }
    }

    public List<V> asList() {
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        OrderedListMap<String, String> orderedListMap = new OrderedListMap<>();
        orderedListMap.put("1", "Image 1");
        orderedListMap.put("2", "Image 2");

        // Iterate over the values
        for (String image : orderedListMap.asList()) {
            System.out.println(image);
        }
    }
}