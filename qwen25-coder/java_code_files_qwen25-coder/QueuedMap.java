import java.util.*;
import java.util.concurrent.*;

public class QueuedMap<K, V> {
    private final Deque<Map.Entry<K, V>> queue = new LinkedBlockingDeque<>();
    private final Map<K, List<Iterator<Map.Entry<K, V>>>> mapById = new ConcurrentHashMap<>();

    public void add(K key, V value) {
        final Map.Entry<K, V> entry = new AbstractMap.SimpleEntry<>(key, value);
        queue.addLast(entry);

        // Create a new list or get the existing one
        List<Iterator<Map.Entry<K, V>>> iterators = mapById.computeIfAbsent(key, k -> new ArrayList<>());

        // Add an iterator that points to this entry in the queue
        Iterator<Map.Entry<K, V>> it = queue.descendingIterator();
        while (it.hasNext()) {
            Map.Entry<K, V> current = it.next();
            if (current.equals(entry)) {
                iterators.add(it);
                break;
            }
        }
    }

    public Map.Entry<K, V> poll() {
        Map.Entry<K, V> entry = queue.pollFirst();
        if (entry != null) {
            // Remove this entry from all related iterators in the map
            K key = entry.getKey();

            List<Iterator<Map.Entry<K, V>>> iterators = mapById.get(key);
            if (iterators != null) {
                Iterator<Iterator<Map.Entry<K, V>>> iteratorIt = iterators.iterator();
                while (iteratorIt.hasNext()) {
                    Iterator<Map.Entry<K, V>> storedIt = iteratorIt.next();
                    if (!storedIt.hasNext()) {
                        iteratorIt.remove();
                    }
                }
                if (iterators.isEmpty()) {
                    mapById.remove(key);
                }
            }
        }
        return entry;
    }

    public V getByKey(K key) {
        List<Iterator<Map.Entry<K, V>>> iterators = mapById.getOrDefault(key, Collections.emptyList());
        if (!iterators.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = iterators.get(0);
            if (it.hasNext()) {
                Map.Entry<K, V> entry = it.next();
                return entry.getValue();
            }
        }
        return null;
    }

    public Map.Entry<K, V> removeByKey(K key) {
        List<Iterator<Map.Entry<K, V>>> iterators = mapById.getOrDefault(key, Collections.emptyList());
        if (!iterators.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = iterators.get(0);
            if (it.hasNext()) {
                Map.Entry<K, V> entry = it.next();
                queue.remove(entry);
                // Remove this iterator from the list
                iterators.remove(it);
                if (iterators.isEmpty()) {
                    mapById.remove(key);
                }
                return entry;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return mapById.containsKey(key);
    }

    public static void main(String[] args) {
    }
}