/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class ProfilingMap<K, V>
implements Map<K, V> {
    private final Map<K, V> delegate;
    private final AtomicLong accessCount = new AtomicLong();
    private final AtomicLong chainLengthSum = new AtomicLong();
    private final AtomicLong maxChainLength = new AtomicLong();
    private final AtomicLong rehashCount = new AtomicLong();

    public ProfilingMap(Map<K, V> map) {
        this.delegate = map;
    }

    @Override
    public V get(Object object) {
        this.accessCount.incrementAndGet();
        int n = 0;
        for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
            if (!entry.getKey().equals(object)) continue;
            ++n;
        }
        this.chainLengthSum.addAndGet(n);
        this.maxChainLength.set(Math.max(this.maxChainLength.get(), (long)n));
        return this.delegate.get(object);
    }

    @Override
    public V put(K k, V v) {
        this.rehashCount.incrementAndGet();
        return this.delegate.put(k, v);
    }

    @Override
    public int size() {
        return this.delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.delegate.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.delegate.containsValue(object);
    }

    @Override
    public V remove(Object object) {
        return this.delegate.remove(object);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        this.delegate.putAll(map);
    }

    @Override
    public void clear() {
        this.delegate.clear();
    }

    @Override
    public Set<K> keySet() {
        return this.delegate.keySet();
    }

    @Override
    public Collection<V> values() {
        return this.delegate.values();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return this.delegate.entrySet();
    }

    public long getAccessCount() {
        return this.accessCount.get();
    }

    public double getAverageChainLength() {
        return (double)this.chainLengthSum.get() / (double)this.accessCount.get();
    }

    public long getMaxChainLength() {
        return this.maxChainLength.get();
    }

    public long getRehashCount() {
        return this.rehashCount.get();
    }

    public static void main(String[] stringArray) {
        HashMap hashMap = new HashMap();
        ProfilingMap<String, String> profilingMap = new ProfilingMap<String, String>(hashMap);
        profilingMap.put("key1", "value1");
        profilingMap.put("key2", "value2");
        System.out.println("Access Count: " + profilingMap.getAccessCount());
        System.out.println("Average Chain Length: " + profilingMap.getAverageChainLength());
        System.out.println("Max Chain Length: " + profilingMap.getMaxChainLength());
        System.out.println("Rehash Count: " + profilingMap.getRehashCount());
    }
}
