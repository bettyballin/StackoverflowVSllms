public class MainClass {

    public static void main(String[] args) {
        // Main method, if needed
    }

    public static class MyLocationOverlay1 extends MyLocationOverlay {
        @Override
        public void drawMyLocation(Canvas canvas, MapView mapView, Location lastFix, GeoPoint myLocation, long when) {
            super.drawMyLocation(canvas, mapView, lastFix, myLocation, when);

            Location bLocation = new Location("revGeo");
            bLocation.setLatitude(FindList.gpslat / 1E7);            // Value = 32.94391
            bLocation.setLongitude(FindList.gpslong / 1E7);          // Value = -96.564615
            Location aLocation = new Location("revGeo");
            aLocation.setLatitude(myLocation.getLatitudeE6() / 1E7);    // Value = 32.946164
            aLocation.setLongitude(myLocation.getLongitudeE6() / 1E7); // Value = -96.505141

            int distance = (int) aLocation.distanceTo(bLocation);   // Value = ~5842 meters?
            String str = " (" + String.valueOf(distance) + " meters)";
        }
    }
    
    public static class MyLocationOverlay {
        public void drawMyLocation(Canvas canvas, MapView mapView, Location lastFix, GeoPoint myLocation, long when){
            // Empty implementation
        }
    }
    
    public static class Canvas {
    }
    
    public static class MapView {
    }
    
    public static class Location {
        public Location(String provider) {
        }
        
        public void setLatitude(double latitude) {
        }
        
        public void setLongitude(double longitude) {
        }

        public double distanceTo(Location dest) {
            return 0.0; // Dummy return value
        }
    }
    
    public static class GeoPoint {
        public int getLatitudeE6() {
            return 329461640; // 32.946164 * 1E7
        }
        
        public int getLongitudeE6() {
            return -965051410; // -96.505141 * 1E7
        }
    }
    
    public static class FindList {
        public static double gpslat = 329439100;   // 32.94391 * 1E7
        public static double gpslong = -965646150; // -96.564615 * 1E7
    }
}