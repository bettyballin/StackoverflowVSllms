/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class PositiveSemidefiniteMatrixGenerator {
    public static void main(String[] stringArray) {
        int n;
        int n2;
        int n3 = 5;
        Random random = new Random();
        double[][] dArray = new double[n3][n3];
        for (int i = 0; i < n3; ++i) {
            for (n2 = 0; n2 < n3; ++n2) {
                dArray[i][n2] = random.nextDouble();
            }
        }
        double[][] dArray2 = new double[n3][n3];
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                for (int i = 0; i < n3; ++i) {
                    double[] dArray3 = dArray2[n2];
                    int n4 = n;
                    dArray3[n4] = dArray3[n4] + dArray[i][n2] * dArray[i][n];
                }
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                System.out.print(dArray2[n2][n] + " ");
            }
            System.out.println();
        }
    }
}
