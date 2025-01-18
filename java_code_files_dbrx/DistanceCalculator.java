public class DistanceCalculator {
    public double calculateDistanceInKilometres(String fromAddress, String toAddress) {
        // Use a geocoding service or library to convert the addresses into coordinates (longitude and latitude).
        // This example assumes two methods, `getCoordinatesFromAddress()`, that return the longitudes and latitudes as Point objects.
        // In real case these will be implemented by making use of respective geocoding libraries API calls/methods
        Point fromLocation = getCoordinatesFromAddress(fromAddress); // Replace this with call to a GeoCode lookup library or service
        Point toLocation = getCoordinatesFromAddress(toAddress);     // Replace this with another similar call

        double originLatitude = fromLocation.getY();
        double destinationLatitude = toLocation.getY();
        double originLongitude = fromLocation.getX();
        double destinationLongitude = toLocation.getX();

        return haversineFormula(originLatitude, destinationLatitude, originLongitude, destinationLongitude);
    }

    private Point getCoordinatesFromAddress(String address) {
        // Your implementation of geo-coding here using a library or API. Below is just placeholder code
        return new Point(0.0, 0.0);  // Replace this line with actual Geocode lookup library call/method.
    }

    private double haversineFormula(double lat1d, double lat2d, double lon1d, double lon2d) {
        double earthRadius = 6371000; // metres
        double lat1r = Math.toRadians(lat1d);
        double lat2r = Math.toRadians(lat2d);
        double latDeltaR = Math.toRadians(lat2d - lat1d);
        double lonDeltaR = Math.toRadians(lon2d - lon1d);

        double a = Math.pow(Math.sin(latDeltaR / 2), 2)
                 + Math.pow(Math.sin(lonDeltaR / 2), 2) * Math.cos(lat1r) * Math.cos(lat2r);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Return distance in meters
        return earthRadius * c;
    }

    public static void main(String[] args) {
        DistanceCalculator dc = new DistanceCalculator();
        double distance = dc.calculateDistanceInKilometres("Address A", "Address B");
        System.out.println("Distance: " + distance + " meters");
    }
}

// Minimal Point class definition
class Point {
    private double x; // longitude
    private double y; // latitude

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}