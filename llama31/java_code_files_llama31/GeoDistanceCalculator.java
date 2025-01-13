/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
import android.location.Location;

public class GeoDistanceCalculator {
    public static void main(String[] stringArray) {
        Location location = new Location("reverseGeocoded");
        location.setLatitude(3.77749E7);
        location.setLongitude(-1.224194E8);
        Location location2 = new Location("reverseGeocoded");
        location2.setLatitude(3.78024E7);
        location2.setLongitude(-1.224056E8);
        Location location3 = new Location("reverseGeocoded");
        location3.setLatitude(location.getLatitude());
        location3.setLongitude(location.getLongitude());
        int n = (int)location3.distanceTo(location2);
        System.out.println("Distance: " + n + " meters");
    }
}
