import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ProfilingMap<K, V> implements Map<K, V> {
    private final Map<K, V> delegate;
    private final AtomicLong accessCount = new AtomicLong();
    private final AtomicLong chainLengthSum = new AtomicLong();
    private final AtomicLong maxChainLength = new AtomicLong();
    private final AtomicLong rehashCount = new AtomicLong();

    public ProfilingMap(Map<K, V> delegate) {
        this.delegate = delegate;
    }

    @Override
    public V get(Object key) {
        accessCount.incrementAndGet();
        // measure chain length
        int chainLength = 0;
        for (Map.Entry<K, V> entry : delegate.entrySet()) {
            if (entry.getKey().equals(key)) {
                chainLength++;
            }
        }
        chainLengthSum.addAndGet(chainLength);
        maxChainLength.set(Math.max(maxChainLength.get(), chainLength));
        return delegate.get(key);
    }

    @Override
    public V put(K key, V value) {
        rehashCount.incrementAndGet();
        return delegate.put(key, value);
    }

    // other map methods...

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return delegate.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return delegate.containsValue(value);
    }

    @Override
    public V remove(Object key) {
        return delegate.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        delegate.putAll(m);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public java.util.Set<K> keySet() {
        return delegate.keySet();
    }

    @Override
    public java.util.Collection<V> values() {
        return delegate.values();
    }

    @Override
    public java.util.Set<Map.Entry<K, V>> entrySet() {
        return delegate.entrySet();
    }

    public long getAccessCount() {
        return accessCount.get();
    }

    public double getAverageChainLength() {
        return (double) chainLengthSum.get() / accessCount.get();
    }

    public long getMaxChainLength() {
        return maxChainLength.get();
    }

    public long getRehashCount() {
        return rehashCount.get();
    }

    public static void main(String[] args) {
        // Test the ProfilingMap class
        Map<String, String> delegate = new java.util.HashMap<>();
        ProfilingMap<String, String> profilingMap = new ProfilingMap<>(delegate);

        profilingMap.put("key1", "value1");
        profilingMap.put("key2", "value2");

        System.out.println("Access Count: " + profilingMap.getAccessCount());
        System.out.println("Average Chain Length: " + profilingMap.getAverageChainLength());
        System.out.println("Max Chain Length: " + profilingMap.getMaxChainLength());
        System.out.println("Rehash Count: " + profilingMap.getRehashCount());
    }
}