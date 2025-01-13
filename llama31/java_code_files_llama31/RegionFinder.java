/*
 * Decompiled with CFR 0.152.
 */
public class RegionFinder {
    public static int findRegion(double[] dArray, double[][] dArray2) {
        double[] dArray3 = RegionFinder.subtract(dArray2[1], dArray2[0]);
        double[] dArray4 = RegionFinder.subtract(dArray2[2], dArray2[0]);
        double[] dArray5 = RegionFinder.subtract(dArray, dArray2[0]);
        double d = RegionFinder.dot(dArray3, dArray3);
        double d2 = RegionFinder.dot(dArray3, dArray4);
        double d3 = RegionFinder.dot(dArray3, dArray5);
        double d4 = RegionFinder.dot(dArray4, dArray4);
        double d5 = RegionFinder.dot(dArray4, dArray5);
        double d6 = 1.0 / (d * d4 - d2 * d2);
        double d7 = (d4 * d3 - d2 * d5) * d6;
        double d8 = (d * d5 - d2 * d3) * d6;
        if (d7 < 0.0 && d8 < 0.0) {
            return 0;
        }
        if (d7 < 0.0 && d8 > 0.0 && d8 < 1.0) {
            return 1;
        }
        if (d7 < 0.0 && d8 > 1.0) {
            return 2;
        }
        if (d7 > 0.0 && d7 < 1.0 && d8 < 0.0) {
            return 3;
        }
        if (d7 > 0.0 && d7 < 1.0 && d8 > 0.0 && d8 < 1.0) {
            return 4;
        }
        if (d7 > 0.0 && d7 < 1.0 && d8 > 1.0) {
            return 5;
        }
        if (d7 > 1.0 && d8 < 0.0) {
            return 6;
        }
        if (d7 > 1.0 && d8 > 0.0 && d8 < 1.0) {
            return 7;
        }
        if (d7 > 1.0 && d8 > 1.0) {
            return 8;
        }
        return -1;
    }

    private static double[] subtract(double[] dArray, double[] dArray2) {
        return new double[]{dArray[0] - dArray2[0], dArray[1] - dArray2[1]};
    }

    private static double dot(double[] dArray, double[] dArray2) {
        return dArray[0] * dArray2[0] + dArray[1] * dArray2[1];
    }

    public static void main(String[] stringArray) {
    }
}
