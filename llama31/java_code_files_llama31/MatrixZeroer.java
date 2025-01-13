/*
 * Decompiled with CFR 0.152.
 */
public class MatrixZeroer {
    public void setZeroes(int[][] nArray) {
        int n;
        int n2;
        int n3 = nArray.length;
        boolean[] blArray = new boolean[n3];
        boolean[] blArray2 = new boolean[n3];
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                if (nArray[n2][n] != 0) continue;
                blArray[n2] = true;
                blArray2[n] = true;
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            for (n = 0; n < n3; ++n) {
                if (!blArray[n2] && !blArray2[n]) continue;
                nArray[n2][n] = 0;
            }
        }
    }

    public static void main(String[] stringArray) {
        MatrixZeroer matrixZeroer = new MatrixZeroer();
        int[][] nArrayArray = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        matrixZeroer.setZeroes(nArrayArray);
        for (int i = 0; i < nArrayArray.length; ++i) {
            for (int j = 0; j < nArrayArray[i].length; ++j) {
                System.out.print(nArrayArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
