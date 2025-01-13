/*
 * Decompiled with CFR 0.152.
 */
public class LineStringSimilarity {
    public static void main(String[] stringArray) {
        double[][] dArrayArray = new double[][]{{1.0, 1.0}, {2.0, 2.0}, {3.0, 3.0}};
        double[][] dArrayArray2 = new double[][]{{1.1, 1.1}, {2.1, 2.1}, {3.1, 3.1}};
        double[][] dArrayArray3 = dArrayArray2;
        double d = LineStringSimilarity.frechetDistance(dArrayArray, dArrayArray3);
        if (d < 0.5) {
            System.out.println("Line strings are similar");
        } else {
            System.out.println("Line strings are not similar");
        }
    }

    public static double frechetDistance(double[][] dArray, double[][] dArray2) {
        int n;
        int n2 = dArray.length;
        int n3 = dArray2.length;
        double[][] dArray3 = new double[n2 + 1][n3 + 1];
        for (n = 0; n <= n2; ++n) {
            dArray3[n][0] = Double.MAX_VALUE;
        }
        for (n = 0; n <= n3; ++n) {
            dArray3[0][n] = Double.MAX_VALUE;
        }
        dArray3[0][0] = 0.0;
        for (n = 1; n <= n2; ++n) {
            for (int i = 1; i <= n3; ++i) {
                double d = Math.sqrt(Math.pow(dArray[n - 1][0] - dArray2[i - 1][0], 2.0) + Math.pow(dArray[n - 1][1] - dArray2[i - 1][1], 2.0));
                dArray3[n][i] = Math.max(Math.min(dArray3[n - 1][i - 1], Math.min(dArray3[n - 1][i], dArray3[n][i - 1])), d);
            }
        }
        return dArray3[n2][n3];
    }
}
