import java.lang.String;

public class SudokuSolver {
    boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) { // Try each number
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board))
                                return true;
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // Trigger backtrack
                }
            }
        }
        return true; // Solved
    }

    boolean isSafe(int[][] board, int row, int col, int num) {
        // Check if 'num' is not in the current row, current column, and current 3x3 box

        // Check row
        for (int x = 0; x < 9; x++)
            if (board[row][x] == num)
                return false;

        // Check column
        for (int x = 0; x < 9; x++)
            if (board[x][col] == num)
                return false;

        // Check 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }

    public static void main(String[] args) {
    }
}