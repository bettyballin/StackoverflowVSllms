import java.util.Collection;
import java.util.Collections;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;

public class LocationManager {

    private static SetMultimap<Region, Location> REGION_TO_LOCATIONS = HashMultimap.create();
    private static SetMultimap<Location, Region> LOCATION_TO_REGION = HashMultimap.create();

    void moveLocationToRegion(Location location, Region new_region) {
        REGION_TO_LOCATIONS.remove(getCurrentRegion(location), location); // remove from current region
        REGION_TO_LOCATIONS.put(new_region, location); // add to the new region
    }

    private Region getCurrentRegion(Location location) {
        // Return the first region associated with the location
        Collection<Region> regions = LOCATION_TO_REGION.get(location);
        if (regions != null && !regions.isEmpty()) {
            return regions.iterator().next();
        } else {
            return null;
        }
    }

    // Fetching regions and locations based on their relationship:
    Collection<Location> getLocationsInRegion(Region rg) {
        return Collections.unmodifiableSet(REGION_TO_LOCATIONS.get(rg)); // returns a set of locations in given region
    }

    ImmutableSet<Region> getRegionsFromLocation(Location loc) {
        return ImmutableSet.copyOf(LOCATION_TO_REGION.get(loc));
    }

    public static void main(String[] args) {
        // Main method content
    }
}

class Location {
    // Assume necessary fields and methods
}

class Region {
    // Assume necessary fields and methods
}