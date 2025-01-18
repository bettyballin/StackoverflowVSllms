import java.util.LinkedHashMap;
import java.util.Map;

public class MRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    public MRUCache(int cacheSize) {
        // Configure the map to remove the eldest entry when its size exceeds 'cacheSize'
        super((int)(Math.ceil(cacheSize / 0.75)) + 1, 0.75f, true);

        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // Only remove the eldest entry if its size is greater than 'cacheSize' to maintain MRU property
        return super.size() > this.cacheSize;
    }

    public static void main(String[] args) {
    }
}