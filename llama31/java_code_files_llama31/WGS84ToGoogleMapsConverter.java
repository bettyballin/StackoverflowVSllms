/*
 * Decompiled with CFR 0.152.
 */
public class WGS84ToGoogleMapsConverter {
    private static final double EARTH_RADIUS = 6378137.0;
    private static final double ORIGIN_SHIFT = Math.PI / 180;

    public static Point wgs84ToGoogleMaps(double d, double d2, int n) {
        double d3 = d2 * (Math.PI / 180);
        double d4 = d * (Math.PI / 180);
        double d5 = d3;
        double d6 = Math.log(Math.tan(0.7853981633974483 + d4 / 2.0));
        int n2 = 1 << n;
        int n3 = (int)(d5 * (double)n2 / (Math.PI * 2) + (double)n2 / 2.0);
        int n4 = (int)((double)n2 / 2.0 - d6 * (double)n2 / (Math.PI * 2));
        return new Point(n3, n4);
    }

    public static Coordinate googleMapsToWgs84(int n, int n2, int n3) {
        int n4 = 1 << n3;
        double d = Math.PI * 2 * ((double)n - (double)n4 / 2.0) / (double)n4;
        double d2 = Math.PI - Math.PI * 2 * (double)n2 / (double)n4;
        double d3 = 2.0 * Math.atan(Math.exp(d2)) - 1.5707963267948966;
        double d4 = d;
        double d5 = d3 / (Math.PI / 180);
        double d6 = d4 / (Math.PI / 180);
        return new Coordinate(d5, d6);
    }

    public static void main(String[] stringArray) {
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int n, int n2) {
            this.x = n;
            this.y = n2;
        }
    }

    public static class Coordinate {
        public double lat;
        public double lon;

        public Coordinate(double d, double d2) {
            this.lat = d;
            this.lon = d2;
        }
    }
}
