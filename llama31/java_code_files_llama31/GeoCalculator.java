/*
 * Decompiled with CFR 0.152.
 */
public class GeoCalculator {
    private double deg2rad(double d) {
        return d * Math.PI / 180.0;
    }

    private double rad2deg(double d) {
        return d * 180.0 / Math.PI;
    }

    public double getDistance(double d, double d2, double d3, double d4) {
        double d5 = d2 - d4;
        double d6 = Math.sin(this.deg2rad(d)) * Math.sin(this.deg2rad(d3)) + Math.cos(this.deg2rad(d)) * Math.cos(this.deg2rad(d3)) * Math.cos(this.deg2rad(d5));
        d6 = Math.acos(d6);
        d6 = this.rad2deg(d6);
        d6 = d6 * 60.0 * 1.1515 * 1.609344;
        return d6;
    }

    public static void main(String[] stringArray) {
        GeoCalculator geoCalculator = new GeoCalculator();
        double d = 40.7128;
        double d2 = 74.006;
        double d3 = 34.0522;
        double d4 = 118.2437;
        double d5 = geoCalculator.getDistance(d, d2, d3, d4);
        System.out.println("The distance between the two points is: " + d5);
    }
}
