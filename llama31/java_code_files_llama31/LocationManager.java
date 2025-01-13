/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class LocationManager {
    private volatile List<Location> locations = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List<Location> getAllLocations() {
        if (this.locations == null) {
            LocationManager locationManager = this;
            synchronized (locationManager) {
                if (this.locations == null) {
                    this.loadAllLocations();
                }
            }
        }
        return this.locations;
    }

    private void loadAllLocations() {
    }

    public static void main(String[] stringArray) {
    }
}
