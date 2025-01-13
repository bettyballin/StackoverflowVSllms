/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LocationCache {
    private ConcurrentHashMap<String, Location> locations = new ConcurrentHashMap();

    public List<Location> getAllLocations() {
        if (this.locations.isEmpty()) {
            this.loadAllLocations();
        }
        return new ArrayList<Location>(this.locations.values());
    }

    private void loadAllLocations() {
        this.locations.put("dummy", new Location());
    }

    public static void main(String[] stringArray) {
        LocationCache locationCache = new LocationCache();
        List<Location> list = locationCache.getAllLocations();
        System.out.println(list);
    }
}
