import java.lang.String;
public class WGS84ToGoogleMaps {

    private static final double TILE_SIZE = 256;

    /**
     * Converts latitude/longitude in WGS84 coordinates to pixel XY coordinates at a given zoom level.
     *
     * @param lat   the latitude coordinate in degrees
     * @param lon   the longitude coordinate in degrees
     * @param zoom  the zoom level of the map
     * @return      an array containing the X and Y pixel coordinates
     */
    public static double[] wgs84ToPixel(double lat, double lon, int zoom) {
        // Convert latitude/longitude to Mercator
        double mx = mercatorX(lon);
        double my = mercatorY(lat);

        // Scale the Mercator coordinates to pixel positions at the given zoom level
        int scale = 1 << zoom;
        double px = (mx + Math.PI) / (2 * Math.PI) * TILE_SIZE * scale;
        double py = (my - Math.log(Math.tan((Math.toRadians(lat) + Math.PI / 4))) / (2 * Math.PI)) * TILE_SIZE * scale;

        return new double[]{px, py};
    }

    /**
     * Converts pixel XY coordinates at a given zoom level to latitude/longitude in WGS84 coordinates.
     *
     * @param px    the X pixel coordinate
     * @param py    the Y pixel coordinate
     * @param zoom  the zoom level of the map
     * @return      an array containing the longitude and latitude coordinates
     */
    public static double[] pixelToWgs84(double px, double py, int zoom) {
        // Calculate the scale factor based on the zoom level
        int scale = 1 << zoom;

        // Convert pixel positions to Mercator coordinates
        double mx = (px / TILE_SIZE * 2 * Math.PI) - Math.PI;
        double my = (py / TILE_SIZE * 2 * Math.PI) - Math.PI;

        // Project Mercator coordinates back to latitude/longitude
        double lon = mercatorXInverse(mx);
        double lat = mercatorYInverse(my);

        return new double[]{lat, lon};
    }

    /**
     * Calculates the X component of the Mercator projection for a given longitude.
     *
     * @param lon   the longitude in degrees
     * @return      the x value on the Mercator projection
     */
    private static double mercatorX(double lon) {
        return Math.toRadians(lon);
    }

    /**
     * Calculates the Y component of the Mercator projection for a given latitude.
     *
     * @param lat   the latitude in degrees
     * @return      the y value on the Mercator projection
     */
    private static double mercatorY(double lat) {
        return Math.log(Math.tan((Math.toRadians(lat) + Math.PI / 4)));
    }

    /**
     * Inverts the X component of the Mercator projection to find longitude.
     *
     * @param x     the x value on the Mercator projection
     * @return      the longitude in degrees
     */
    private static double mercatorXInverse(double x) {
        return Math.toDegrees(x);
    }

    /**
     * Inverts the Y component of the Mercator projection to find latitude.
     *
     * @param y     the y value on the Mercator projection
     * @return      the latitude in degrees
     */
    private static double mercatorYInverse(double y) {
        return Math.toDegrees(2 * Math.atan(Math.exp(y)) - Math.PI / 2);
    }

    public static void main(String[] args) {
        // Example usage
        double lat = 51.0474; // Latitude in degrees
        double lon = -114.0719; // Longitude in degrees
        int zoom = 13; // Zoom level

        double[] pixelCoordinates = wgs84ToPixel(lat, lon, zoom);
        System.out.println("Pixel X: " + pixelCoordinates[0] + ", Pixel Y: " + pixelCoordinates[1]);

        double[] wgs84Coordinates = pixelToWgs84(pixelCoordinates[0], pixelCoordinates[1], zoom);
        System.out.println("Latitude: " + wgs84Coordinates[0] + ", Longitude: " + wgs84Coordinates[1]);
    }
}