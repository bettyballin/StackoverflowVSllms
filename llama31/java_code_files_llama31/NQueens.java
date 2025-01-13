/*
 * Decompiled with CFR 0.152.
 */
public class NQueens {
    private static final int N = 4;

    private static boolean isSafe(int[][] nArray, int n, int n2) {
        int n3;
        int n4;
        for (n4 = 0; n4 < n; ++n4) {
            if (nArray[n4][n2] != 1) continue;
            return false;
        }
        n4 = n;
        for (n3 = n2; n4 >= 0 && n3 >= 0; --n4, --n3) {
            if (nArray[n4][n3] != 1) continue;
            return false;
        }
        n4 = n;
        for (n3 = n2; n4 >= 0 && n3 < 4; --n4, ++n3) {
            if (nArray[n4][n3] != 1) continue;
            return false;
        }
        return true;
    }

    private static boolean solveNQueens(int[][] nArray, int n) {
        if (n == 4) {
            return true;
        }
        for (int i = 0; i < 4; ++i) {
            if (!NQueens.isSafe(nArray, n, i)) continue;
            nArray[n][i] = 1;
            if (NQueens.solveNQueens(nArray, n + 1)) {
                return true;
            }
            nArray[n][i] = 0;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        int[][] nArray = new int[4][4];
        if (NQueens.solveNQueens(nArray, 0)) {
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    System.out.print(nArray[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
    }
}
