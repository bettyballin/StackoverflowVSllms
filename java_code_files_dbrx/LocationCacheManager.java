import java.util.List;
import java.util.stream.Collectors;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class LocationCacheManager {
    private final LoadingCache<Long, Location> locationCache = Caffeine.newBuilder()
        .build(this::loadLocation);

    public List<Location> getAllLocations() {
         return locationCache.asMap().values().stream().collect(Collectors.toList());
    }

    private Location loadLocation(Long locationId){ /* Load Location by id */ }

    public static void main(String[] args) {
    }
}

class Location {
    // Placeholder for the Location class
}