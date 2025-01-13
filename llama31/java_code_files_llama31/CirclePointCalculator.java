/*
 * Decompiled with CFR 0.152.
 */
public class CirclePointCalculator {
    public static double[] calculatePoint(double d, double d2, double[] dArray) {
        double d3 = d * Math.cos(d2) + (dArray != null ? dArray[0] : 0.0);
        double d4 = d * Math.sin(d2) + (dArray != null ? dArray[1] : 0.0);
        return new double[]{d3, d4};
    }

    public static void main(String[] stringArray) {
    }
}
