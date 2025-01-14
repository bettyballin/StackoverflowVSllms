import java.lang.String;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = { /* your data here */ };
        int[][] B = { /* your data here */ };
        int N = A.length; // assuming square matrices and equal dimensions
        int[][] C = new int[N][N]; 

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MatrixMultiplicationTask(A, B, C, 0, N));
        
        // print C or perform further operations...
    }

    static class MatrixMultiplicationTask extends RecursiveAction {
        private final int[][] A, B, C;
        private final int fromRow, toRow;

        MatrixMultiplicationTask(int[][] a, int[][] b, int[][] c, int from, int to) {
            this.A = a; this.B = b; this.C = c;
            this.fromRow = from; this.toRow = to;
        }

        @Override
        protected void compute() {
            if (toRow - fromRow < 1000) { // threshold for parallelization
                multiply(A, B, C, fromRow, toRow);
            } else {
                int middle = (fromRow + toRow) / 2;
                invokeAll(new MatrixMultiplicationTask(A, B, C, fromRow, middle),
                          new MatrixMultiplicationTask(A, B, C, middle, toRow));
            }
        }

        private void multiply(int[][] a, int[][] b, int[][] c, int fromRow, int toRow) {
            for (int row = fromRow; row < toRow; ++row)
                for (int col = 0; col < a.length; ++col)
                    for (int inner = 0; inner < a.length; ++inner)
                        c[row][col] += a[row][inner] * b[inner][col];
        }
    }
}