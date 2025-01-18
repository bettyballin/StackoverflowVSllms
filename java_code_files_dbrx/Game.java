import java.util.Map;
import java.util.Collection;

import com.google.common.collect.Multimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableListMultimap;

public class Game {

    private static final Multimap<Region, Location> REGION_TO_LOCATIONS = HashMultimap.create();
    private static final ImmutableListMultimap<Location, Region> LOCATION_TO_REGION;

    static {
        // Mapping locations to regions and vice versa in the constructor or a static block.
        Multimap<Location, Region> temp = HashMultimap.create();
        for (Map.Entry<Region, Collection<Location>> regionToLocations : REGION_TO_LOCATIONS.asMap().entrySet()) {
            Region rg = regionToLocations.getKey();
            Collection<Location> locs = regionToLocations.getValue();
            for (Location loc : locs) {
                temp.put(loc, rg); // Adding location-region pairs
            }
        }
        LOCATION_TO_REGION = ImmutableListMultimap.copyOf(temp); // Convert back to an immutable list multimap.
    }

    public static void main(String[] args) {
        // Your code here
    }
}

// Placeholder classes for Region and Location
class Region {
    // Define fields and methods as needed
}

class Location {
    // Define fields and methods as needed
}