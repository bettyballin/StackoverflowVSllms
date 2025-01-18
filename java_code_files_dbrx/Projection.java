public class Projection {
    private static final double DEG2RAD = Math.PI / 180.0;
    private static final double INITIAL_RESOLUTION = 2 * Math.PI * 6378137.0 / (256 * Math.pow(2, 8)); // initial resolution in meters per pixel
    private static final double ORIGIN_SHIFT = 2 * Math.PI * 6378137.0 / 2; // a fundamental shift constant for Google Map

    public int[] toPixelXY(double lat, double lon) {
        double x = (lon + 180) / 360;
        double sinLatitude = Math.sin(lat * DEG2RAD);
        double y = 0.5 - (Math.log((1 + sinLatitude) / (1 - sinLatitude)) / (4 * Math.PI));

        return new int[]{(int)(x * ORIGIN_SHIFT), (int)((1 - y) * ORIGIN_SHIFT)};
    }

    public double[] toLonLat(int x, int y, int zoomLevel) {
        double res = INITIAL_RESOLUTION / Math.pow(2, zoomLevel);
        double longitude = (x * res - ORIGIN_SHIFT) / 180; // degrees
        double latitudeRadians = ((y * res - ORIGIN_SHIFT) + (ORIGIN_SHIFT / 2)) * DEG2RAD;
        double latitudeDegrees = Math.toDegrees(2 * Math.atan(Math.exp(latitudeRadians)) - Math.PI / 2); // degrees

        return new double[]{longitude, latitudeDegrees};
    }

    public static void main(String[] args) {
    }
}