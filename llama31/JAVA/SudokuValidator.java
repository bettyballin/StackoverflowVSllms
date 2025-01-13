import java.lang.String;

public class SudokuValidator {
    public boolean isValidSudoku(int[][] board) {
        int n = board.length;

        // Check rows and columns
        for (int i = 0; i < n; i++) {
            boolean[] seenRow = new boolean[n];
            boolean[] seenCol = new boolean[n];
            for (int j = 0; j < n; j++) {
                int rowVal = board[i][j];
                int colVal = board[j][i];
                if (rowVal != 0 && seenRow[rowVal - 1]) return false;
                if (colVal != 0 && seenCol[colVal - 1]) return false;
                seenRow[rowVal - 1] = true;
                seenCol[colVal - 1] = true;
            }
        }

        // Check boxes
        for (int i = 0; i < n; i += (int) Math.sqrt(n)) {
            for (int j = 0; j < n; j += (int) Math.sqrt(n)) {
                boolean[] seenBox = new boolean[n];
                for (int k = 0; k < (int) Math.sqrt(n); k++) {
                    for (int l = 0; l < (int) Math.sqrt(n); l++) {
                        int boxVal = board[i + k][j + l];
                        if (boxVal != 0 && seenBox[boxVal - 1]) return false;
                        seenBox[boxVal - 1] = true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SudokuValidator validator = new SudokuValidator();
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(validator.isValidSudoku(board));
    }
}