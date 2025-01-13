/*
 * Decompiled with CFR 0.152.
 */
public class ImageSegmentation {
    public static void main(String[] stringArray) {
        int[][] nArrayArray = new int[][]{{1, 1, 1, 2, 2}, {1, 1, 1, 2, 2}, {3, 3, 3, 4, 4}, {3, 3, 3, 4, 4}};
        int[][] nArray = ImageSegmentation.segmentImage(nArrayArray);
        for (int i = 0; i < nArray.length; ++i) {
            for (int j = 0; j < nArray[i].length; ++j) {
                System.out.print(nArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] segmentImage(int[][] nArray) {
        int n = nArray[0].length;
        int n2 = nArray.length;
        int[][] nArray2 = new int[n2][n];
        int n3 = 1;
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nArray2[i][j] != 0) continue;
                ImageSegmentation.floodFill(nArray, nArray2, j, i, n3, nArray[i][j]);
                ++n3;
            }
        }
        return nArray2;
    }

    public static void floodFill(int[][] nArray, int[][] nArray2, int n, int n2, int n3, int n4) {
        if (n < 0 || n >= nArray[0].length || n2 < 0 || n2 >= nArray.length) {
            return;
        }
        if (nArray2[n2][n] != 0 || nArray[n2][n] != n4) {
            return;
        }
        nArray2[n2][n] = n3;
        ImageSegmentation.floodFill(nArray, nArray2, n - 1, n2, n3, n4);
        ImageSegmentation.floodFill(nArray, nArray2, n + 1, n2, n3, n4);
        ImageSegmentation.floodFill(nArray, nArray2, n, n2 - 1, n3, n4);
        ImageSegmentation.floodFill(nArray, nArray2, n, n2 + 1, n3, n4);
    }
}
