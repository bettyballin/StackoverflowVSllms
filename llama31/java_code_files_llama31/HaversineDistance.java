/*
 * Decompiled with CFR 0.152.
 */
public class HaversineDistance {
    public static double haversineDistance(double d, double d2, double d3, double d4) {
        double d5 = 6371.0;
        double d6 = Math.toRadians(d3 - d);
        double d7 = Math.toRadians(d4 - d2);
        double d8 = Math.sin(d6 / 2.0) * Math.sin(d6 / 2.0) + Math.cos(Math.toRadians(d)) * Math.cos(Math.toRadians(d3)) * Math.sin(d7 / 2.0) * Math.sin(d7 / 2.0);
        double d9 = 2.0 * Math.atan2(Math.sqrt(d8), Math.sqrt(1.0 - d8));
        double d10 = d5 * d9;
        return d10;
    }

    public static void main(String[] stringArray) {
        double d = 40.7128;
        double d2 = -74.006;
        double d3 = 34.0522;
        double d4 = -118.2437;
        System.out.println(HaversineDistance.haversineDistance(d, d2, d3, d4));
    }
}
