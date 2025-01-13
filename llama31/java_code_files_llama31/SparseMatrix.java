/*
 * Decompiled with CFR 0.152.
 */
public class SparseMatrix {
    private int[][] matrix;
    private boolean[] rowsZeroed;
    private boolean[] colsZeroed;

    public SparseMatrix(int n, int n2) {
        this.matrix = new int[n][n2];
        this.rowsZeroed = new boolean[n];
        this.colsZeroed = new boolean[n2];
    }

    public void zeroRow(int n) {
        this.rowsZeroed[n] = true;
    }

    public void zeroCol(int n) {
        this.colsZeroed[n] = true;
    }

    public int get(int n, int n2) {
        if (this.rowsZeroed[n] || this.colsZeroed[n2]) {
            return 0;
        }
        return this.matrix[n][n2];
    }

    public static void main(String[] stringArray) {
    }
}
