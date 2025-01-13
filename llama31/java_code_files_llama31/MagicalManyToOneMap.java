/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

class MagicalManyToOneMap<K, V> {
    private Map<K, V> forwardMap = new HashMap();
    private Map<V, Set<K>> inverseMap = new HashMap<V, Set<K>>();

    MagicalManyToOneMap() {
    }

    public V get(K k) {
        return this.forwardMap.get(k);
    }

    public void put(K k, V v) {
        this.forwardMap.put(k, v);
        this.inverseMap.computeIfAbsent((Set)v, (Function<Set, Set<Object>>)((Function<Object, Set>)object -> new HashSet())).add(k);
        this.inverseMap.forEach((object2, set) -> set.remove(k));
    }

    public Set<K> getInverse(V v) {
        return this.inverseMap.getOrDefault(v, Collections.emptySet());
    }
}
