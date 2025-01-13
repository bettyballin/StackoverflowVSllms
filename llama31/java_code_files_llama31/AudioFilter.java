/*
 * Decompiled with CFR 0.152.
 */
public class AudioFilter {
    public static double[] lowPassFilter(double[] dArray, double d) {
        double[] dArray2 = new double[dArray.length];
        double d2 = 0.5;
        dArray2[0] = dArray[0];
        for (int i = 1; i < dArray.length; ++i) {
            dArray2[i] = (1.0 - d2) * dArray[i] + d2 * dArray2[i - 1];
        }
        return dArray2;
    }

    public static double[] highPassFilter(double[] dArray, double d) {
        double[] dArray2 = new double[dArray.length];
        double d2 = 0.5;
        dArray2[0] = dArray[0];
        for (int i = 1; i < dArray.length; ++i) {
            dArray2[i] = (1.0 + d2) * dArray[i] - d2 * dArray2[i - 1];
        }
        return dArray2;
    }

    public static void main(String[] stringArray) {
    }
}
