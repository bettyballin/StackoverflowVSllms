/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Interpolator {
    public static double[][] interpolate(double[] dArray, double[] dArray2) {
        int n = dArray.length;
        int n2 = dArray2.length;
        int n3 = n + n2 - 1;
        double[] dArray3 = new double[n3];
        double[] dArray4 = new double[n3];
        int n4 = 0;
        int n5 = 0;
        for (int i = 0; i < n3; ++i) {
            double d = (double)i / (double)(n3 - 1);
            if (n4 < n - 1 && n5 < n2 - 1) {
                double d2 = (d - (double)n4) / (double)(n4 + 1 - n4);
                dArray3[i] = dArray[n4] + d2 * (dArray[n4 + 1] - dArray[n4]);
                dArray4[i] = dArray2[n5] + d2 * (dArray2[n5 + 1] - dArray2[n5]);
                if (!(d2 >= 0.5)) continue;
                ++n4;
                ++n5;
                continue;
            }
            if (n4 < n - 1) {
                dArray3[i] = dArray[n4] + (d - (double)n4) * (dArray[n4 + 1] - dArray[n4]);
                dArray4[i] = dArray2[n2 - 1];
                ++n4;
                continue;
            }
            dArray3[i] = dArray[n - 1];
            dArray4[i] = dArray2[n5] + (d - (double)n5) * (dArray2[n5 + 1] - dArray2[n5]);
            ++n5;
        }
        return new double[][]{dArray3, dArray4};
    }

    public static void main(String[] stringArray) {
        double[] dArray = new double[]{1.0, 4.0, 9.0, 16.0, 25.0, 36.0};
        double[] dArray2 = new double[]{6.0, 9.0, 14.0, 30.0};
        double[][] dArray3 = Interpolator.interpolate(dArray, dArray2);
        System.out.println("Result 1: " + Arrays.toString(dArray3[0]));
        System.out.println("Result 2: " + Arrays.toString(dArray3[1]));
    }
}
