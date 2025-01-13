/*
 * Decompiled with CFR 0.152.
 */
public class Main_397 {
    public static void main(String[] stringArray) {
        int n;
        int n2;
        int n3 = 10;
        int[][] nArray = new int[n3][n3];
        int n4 = 1;
        int n5 = 2;
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                nArray[n2][n] = n2 + n;
            }
        }
        n2 = Integer.MAX_VALUE;
        for (n = 1; n < n3; ++n) {
            int n6 = nArray[n][n3 - 1] + Main_397.dist(n4, n5);
            if (n6 >= n2) continue;
            n2 = n6;
        }
        System.out.println(n2);
    }

    public static int dist(int n, int n2) {
        return Math.abs(n - n2);
    }
}
