import java.lang.String;

public class MatrixTransformer {
    public static void transposeBlocking(int[][] A, int blockSize) {
        for (int i = 0; i < A[0].length; i += blockSize) {
            for (int j = 0; j < A.length; j += blockSize) {
                transposeBlock(A, i, j, blockSize);
            }
        }
    }

    public static void transposeBlock(int[][] A, int x, int y, int blockSize) {
        for (int i = 0; i < blockSize; ++i) {
            for (int j = 0; j < blockSize; ++j) {
                // Check that the coordinates are within bounds.
                if (y + j < A.length && x + i < A[0].length) {
                    swapElementsAtIndices(A, x + i, y + j, y + j, x + i);
                }
            }
        }
    }

    public static void swapElementsAtIndices(int[][] A, int x1, int y1, int x2, int y2) {
        int temp = A[y1][x1];
        A[y1][x1] = A[y2][x2];
        A[y2][x2] = temp;
    }

    public static void main(String[] args) {
    }
}