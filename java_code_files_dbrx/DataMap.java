import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class DataMap<K, V> {
    private ConcurrentHashMap<K, SoftReference<V>> m_map = new ConcurrentHashMap<K, SoftReference<V>>();

    public boolean put(K key, V value) {
        SoftReference<V> ref = new SoftReference<V>(value);
        return m_map.putIfAbsent(key, ref) == null;
    }

    public V get(K key) {
        SoftReference<V> ref = m_map.get(key);
        if (ref != null) {
            V val = ref.get();
            // Check whether we have not been cleared yet as soft references can be reclaimed by a GC at any time....
            if (val != null) {
                return val;
            }
        }
        throw new KeyNotFoundException("No value found for key [" + key + "]");
    }

    public static class KeyNotFoundException extends RuntimeException {
        public KeyNotFoundException(String message) {
            super(message);
        }
    }
}