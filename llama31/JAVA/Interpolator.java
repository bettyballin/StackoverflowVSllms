import java.lang.String;
import java.util.Arrays;

public class Interpolator {
    public static double[][] interpolate(double[] a1, double[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        int n = n1 + n2 - 1;
        double[] result1 = new double[n];
        double[] result2 = new double[n];

        int i1 = 0, i2 = 0;
        for (int i = 0; i < n; i++) {
            double x = (double) i / (n - 1);
            if (i1 < n1 - 1 && i2 < n2 - 1) {
                double t = (x - i1) / (i1 + 1 - i1);
                result1[i] = a1[i1] + t * (a1[i1 + 1] - a1[i1]);
                result2[i] = a2[i2] + t * (a2[i2 + 1] - a2[i2]);
                if (t >= 0.5) {
                    i1++;
                    i2++;
                }
            } else if (i1 < n1 - 1) {
                result1[i] = a1[i1] + (x - i1) * (a1[i1 + 1] - a1[i1]);
                result2[i] = a2[n2 - 1];
                i1++;
            } else {
                result1[i] = a1[n1 - 1];
                result2[i] = a2[i2] + (x - i2) * (a2[i2 + 1] - a2[i2]);
                i2++;
            }
        }
        return new double[][]{result1, result2};
    }

    public static void main(String[] args) {
        double[] a1 = {1, 4, 9, 16, 25, 36};
        double[] a2 = {6, 9, 14, 30};
        double[][] result = interpolate(a1, a2);
        System.out.println("Result 1: " + Arrays.toString(result[0]));
        System.out.println("Result 2: " + Arrays.toString(result[1]));
    }
}