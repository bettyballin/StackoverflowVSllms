/*
 * Decompiled with CFR 0.152.
 */
public class MatrixRotator {
    public static void rotate(int[][] nArray) {
        int n = nArray.length;
        for (int i = 0; i < n / 2; ++i) {
            int n2 = i;
            int n3 = n - i - 1;
            for (int j = n2; j < n3; ++j) {
                int n4 = j - n2;
                int n5 = nArray[n2][j];
                nArray[n2][j] = nArray[n3 - n4][n2];
                nArray[n3 - n4][n2] = nArray[n3][n3 - n4];
                nArray[n3][n3 - n4] = nArray[j][n3];
                nArray[j][n3] = n5;
            }
        }
    }

    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Before rotation:");
        MatrixRotator.printMatrix(nArrayArray);
        MatrixRotator.rotate(nArrayArray);
        System.out.println("After rotation:");
        MatrixRotator.printMatrix(nArrayArray);
    }

    public static void printMatrix(int[][] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            for (int j = 0; j < nArray[i].length; ++j) {
                System.out.print(nArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
