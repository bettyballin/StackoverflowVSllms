import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Assuming themap is your TreeBidiMap instance
        TreeBidiMap<Object, Double> themap = new TreeBidiMap<>();

        // Retrieve the collection of values
        Collection<Double> coll = themap.values();

        // Convert Collection to List
        List<Double> list = new ArrayList<>(coll);

        // Sort the list
        Collections.sort(list);

        // Iterate over the sorted list and get keys from the map
        for (Double value : list) {
            Object key = themap.getKey(value);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}

class TreeBidiMap<K, V> {
    private Map<K, V> keyToValue = new HashMap<>();
    private Map<V, K> valueToKey = new HashMap<>();

    public void put(K key, V value) {
        keyToValue.put(key, value);
        valueToKey.put(value, key);
    }

    public V get(K key) {
        return keyToValue.get(key);
    }

    public K getKey(V value) {
        return valueToKey.get(value);
    }

    public Collection<V> values() {
        return keyToValue.values();
    }
}