import java.util.*;

// Define the MagicalManyToOneMap class
class MagicalManyToOneMap<K, V> {
    private Map<K, V> forwardMap = new HashMap<>();
    private Map<V, Set<K>> inverseMap = new HashMap<>();

    public V get(K key) {
        return forwardMap.get(key);
    }

    public void put(K key, V value) {
        forwardMap.put(key, value);
        inverseMap.computeIfAbsent(value, k -> new HashSet<>()).add(key);
        // Remove the key from the previous inverse mapping (if any)
        inverseMap.forEach((k, set) -> set.remove(key));
    }

    public Set<K> getInverse(V value) {
        return inverseMap.getOrDefault(value, Collections.emptySet());
    }
}

// Define the Game class
class Game {
    public static Location chooseSomeLocation() {
        // Return a random location (for demonstration purposes)
        return new Location("Random Location");
    }

    public static Region getSomeOtherRegion() {
        // Return a random region (for demonstration purposes)
        return new Region("Random Region");
    }
}

// Define the Location class
class Location {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Define the Region class
class Region {
    private String name;

    public Region(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main_119 {
    public static void main(String[] args) {
        MagicalManyToOneMap<Location, Region> forward = new MagicalManyToOneMap<>();

        Location parkplace = Game.chooseSomeLocation();
        Region mine = new Region("Mine");
        forward.put(parkplace, mine);

        Region other = Game.getSomeOtherRegion();
        forward.put(parkplace, other);

        for (Location l : forward.getInverse(mine)) {
            System.out.println("Location: " + l);
            // do something clever
        }
    }
}