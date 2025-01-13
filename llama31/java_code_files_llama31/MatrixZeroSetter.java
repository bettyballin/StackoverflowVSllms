/*
 * Decompiled with CFR 0.152.
 */
public class MatrixZeroSetter {
    public void setZeroes(int[][] nArray) {
        int n;
        int n2;
        int n3 = nArray.length;
        boolean bl = false;
        boolean bl2 = false;
        for (n2 = 0; n2 < n3; ++n2) {
            if (nArray[n2][0] == 0) {
                bl2 = true;
            }
            for (n = 1; n < n3; ++n) {
                if (nArray[n2][n] != 0) continue;
                if (n2 == 0) {
                    bl = true;
                }
                nArray[n2][0] = 0;
                nArray[0][n] = 0;
            }
        }
        for (n2 = 1; n2 < n3; ++n2) {
            for (n = 1; n < n3; ++n) {
                if (nArray[n2][0] != 0 && nArray[0][n] != 0) continue;
                nArray[n2][n] = 0;
            }
        }
        if (bl) {
            for (n2 = 0; n2 < n3; ++n2) {
                nArray[0][n2] = 0;
            }
        }
        if (bl2) {
            for (n2 = 0; n2 < n3; ++n2) {
                nArray[n2][0] = 0;
            }
        }
    }

    public static void main(String[] stringArray) {
        MatrixZeroSetter matrixZeroSetter = new MatrixZeroSetter();
        int[][] nArrayArray = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        matrixZeroSetter.setZeroes(nArrayArray);
        for (int i = 0; i < nArrayArray.length; ++i) {
            for (int j = 0; j < nArrayArray.length; ++j) {
                System.out.print(nArrayArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
