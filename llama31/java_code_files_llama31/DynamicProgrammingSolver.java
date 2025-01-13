/*
 * Decompiled with CFR 0.152.
 */
public class DynamicProgrammingSolver {
    public static void main(String[] stringArray) {
        int n;
        int n2;
        int n3;
        int n4 = 10;
        int[][][] nArray = new int[n4][n4][n4];
        for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                for (n = 0; n < n4; ++n) {
                    nArray[n3][n2][n] = 0;
                }
            }
        }
        for (n3 = 1; n3 < n4; ++n3) {
            for (n2 = 1; n2 < n4; ++n2) {
                for (n = 1; n < n4; ++n) {
                    nArray[n3][n2][n] = Math.max(nArray[n3 - 1][n2][n], Math.max(nArray[n3][n2 - 1][n], nArray[n3][n2][n - 1]));
                }
            }
        }
    }
}
