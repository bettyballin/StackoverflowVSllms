/*
 * Decompiled with CFR 0.152.
 */
public class Main_639 {
    public static void main(String[] stringArray) {
        int n;
        int n2;
        int[][] nArrayArray = new int[][]{{0, 0, 1, 1, 0}, {0, 0, 0, 0, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}};
        int n3 = 3;
        long[][] lArray = new long[n3 + 1][nArrayArray.length];
        for (n2 = 0; n2 < nArrayArray.length; ++n2) {
            lArray[1][n2] = 1L;
        }
        for (n2 = 2; n2 <= n3; ++n2) {
            for (int i = 0; i < nArrayArray.length; ++i) {
                for (n = 0; n < nArrayArray.length; ++n) {
                    if (nArrayArray[n][i] != 1) continue;
                    long[] lArray2 = lArray[n2];
                    int n4 = i;
                    lArray2[n4] = lArray2[n4] + lArray[n2 - 1][n];
                }
            }
        }
        long l = 0L;
        for (n = 0; n < nArrayArray.length; ++n) {
            l += lArray[n3][n];
        }
        System.out.println("Total number of valid strings: " + l);
    }
}
