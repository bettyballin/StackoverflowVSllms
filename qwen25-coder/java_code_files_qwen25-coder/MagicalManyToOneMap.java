import java.util.*;

public class MagicalManyToOneMap<K, V> {
    private final Map<K, V> forwardMap;
    private final Map<V, Set<K>> reverseMap;

    public MagicalManyToOneMap() {
        this.forwardMap = new HashMap<>();
        this.reverseMap = new HashMap<>();
    }

    public V get(K key) {
        return forwardMap.get(key);
    }

    public void put(K key, V value) {
        removeKeyFromInverseMap(key);

        forwardMap.put(key, value);
        reverseMap.computeIfAbsent(value, v -> new HashSet<>()).add(key);
    }

    private void removeKeyFromInverseMap(K key) {
        V oldValue = forwardMap.get(key);
        if (oldValue != null) {
            Set<K> set = reverseMap.get(oldValue);
            if (set != null) {
                set.remove(key);
                if (set.isEmpty()) {
                    reverseMap.remove(oldValue);
                }
            }
        }
    }

    public Map<V, Set<K>> getInverse() {
        return Collections.unmodifiableMap(reverseMap);
    }

    public static void main(String[] args) {
        MagicalManyToOneMap<Location, Region> forward = new MagicalManyToOneMap<>();
        Location parkplace = new Location();
        Region mine = new Region();
        Region other = new Region();

        // Test putting and getting
        forward.put(parkplace, mine);
        assert forward.get(parkplace).equals(mine);

        // Test moving a location from one region to another
        forward.put(parkplace, other);
        assert !forward.getInverse().getOrDefault(mine, Collections.emptySet()).contains(parkplace);
        assert forward.get(parkplace).equals(other);

        System.out.println("Tests passed.");
    }

    static class Location {
        // Location fields and methods go here
    }

    static class Region {
        // Region fields and methods go here
    }
}