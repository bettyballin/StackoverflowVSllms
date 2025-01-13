/*
 * Decompiled with CFR 0.152.
 */
public class AngleCalculator {
    public static double calculateAngle(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = AngleCalculator.distance(d, d2, d3, d4);
        double d8 = AngleCalculator.distance(d, d2, d5, d6);
        double d9 = AngleCalculator.distance(d3, d4, d5, d6);
        return Math.acos((d7 * d7 + d8 * d8 - d9 * d9) / (2.0 * d7 * d8));
    }

    private static double distance(double d, double d2, double d3, double d4) {
        return Math.sqrt(Math.pow(d3 - d, 2.0) + Math.pow(d4 - d2, 2.0));
    }

    public static void main(String[] stringArray) {
    }
}
