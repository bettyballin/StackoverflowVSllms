/*
 * Decompiled with CFR 0.152.
 */
public class DistanceCalculator_1 {
    private static final double EARTH_RADIUS = 6371.0;

    public static double calculateDistance(double d, double d2, double d3, double d4) {
        double d5 = DistanceCalculator_1.toRadians(d3 - d);
        double d6 = DistanceCalculator_1.toRadians(d4 - d2);
        double d7 = DistanceCalculator_1.toRadians(d);
        double d8 = DistanceCalculator_1.toRadians(d3);
        double d9 = Math.sin(d5 / 2.0) * Math.sin(d5 / 2.0) + Math.sin(d6 / 2.0) * Math.sin(d6 / 2.0) * Math.cos(d7) * Math.cos(d8);
        double d10 = 2.0 * Math.atan2(Math.sqrt(d9), Math.sqrt(1.0 - d9));
        return 6371.0 * d10;
    }

    private static double toRadians(double d) {
        return d * Math.PI / 180.0;
    }

    public static void main(String[] stringArray) {
        double d = 52.52;
        double d2 = 13.405;
        double d3 = 48.8566;
        double d4 = 2.3522;
        double d5 = DistanceCalculator_1.calculateDistance(d, d2, d3, d4);
        System.out.println("Distance between Berlin and Paris: " + d5 + " km");
    }
}
