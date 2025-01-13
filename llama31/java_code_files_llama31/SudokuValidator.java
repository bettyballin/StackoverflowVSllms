/*
 * Decompiled with CFR 0.152.
 */
public class SudokuValidator {
    public boolean isValidSudoku(int[][] nArray) {
        int n;
        int n2;
        int n3;
        boolean[] blArray;
        int n4;
        int n5 = nArray.length;
        for (n4 = 0; n4 < n5; ++n4) {
            boolean[] blArray2 = new boolean[n5];
            blArray = new boolean[n5];
            for (n3 = 0; n3 < n5; ++n3) {
                n2 = nArray[n4][n3];
                n = nArray[n3][n4];
                if (n2 != 0 && blArray2[n2 - 1]) {
                    return false;
                }
                if (n != 0 && blArray[n - 1]) {
                    return false;
                }
                blArray2[n2 - 1] = true;
                blArray[n - 1] = true;
            }
        }
        for (n4 = 0; n4 < n5; n4 += (int)Math.sqrt(n5)) {
            for (int i = 0; i < n5; i += (int)Math.sqrt(n5)) {
                blArray = new boolean[n5];
                for (n3 = 0; n3 < (int)Math.sqrt(n5); ++n3) {
                    for (n2 = 0; n2 < (int)Math.sqrt(n5); ++n2) {
                        n = nArray[n4 + n3][i + n2];
                        if (n != 0 && blArray[n - 1]) {
                            return false;
                        }
                        blArray[n - 1] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] stringArray) {
        SudokuValidator sudokuValidator = new SudokuValidator();
        int[][] nArrayArray = new int[][]{{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        System.out.println(sudokuValidator.isValidSudoku(nArrayArray));
    }
}
