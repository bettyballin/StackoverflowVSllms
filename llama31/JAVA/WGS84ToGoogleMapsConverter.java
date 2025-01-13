import java.lang.String;
public class WGS84ToGoogleMapsConverter {

    private static final double EARTH_RADIUS = 6378137.0; // in meters
    private static final double ORIGIN_SHIFT = Math.PI / 180.0; // convert degrees to radians

    public static Point wgs84ToGoogleMaps(double lat, double lon, int zoom) {
        double x = lon * ORIGIN_SHIFT;
        double y = lat * ORIGIN_SHIFT;

        double mercatorX = x;
        double mercatorY = Math.log(Math.tan(Math.PI / 4.0 + y / 2.0));

        // scale to pixel coordinates
        int scale = 1 << zoom;
        int pixelX = (int) (mercatorX * scale / (2.0 * Math.PI) + scale / 2.0);
        int pixelY = (int) (scale / 2.0 - mercatorY * scale / (2.0 * Math.PI));

        return new Point(pixelX, pixelY);
    }

    public static Coordinate googleMapsToWgs84(int pixelX, int pixelY, int zoom) {
        int scale = 1 << zoom;
        double mercatorX = 2.0 * Math.PI * (pixelX - scale / 2.0) / scale;
        double mercatorY = Math.PI - 2.0 * Math.PI * pixelY / scale;

        double y = 2.0 * Math.atan(Math.exp(mercatorY)) - Math.PI / 2.0;
        double x = mercatorX;

        double lat = y / ORIGIN_SHIFT;
        double lon = x / ORIGIN_SHIFT;

        return new Coordinate(lat, lon);
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Coordinate {
        public double lat;
        public double lon;

        public Coordinate(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }
    }

	public static void main(String[] args) {
	}
}