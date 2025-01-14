import java.lang.String;
public class TicTacToe {

    private char[][] board;
    private int size; // n
    private int winCondition; // x

    public TicTacToe(int size, int winCondition) {
        this.size = size;
        this.winCondition = winCondition;
        this.board = new char[size][size];
    }

    public boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            if (checkRow(i, player) || checkColumn(i, player)) {
                return true;
            }
        }
        // Check diagonals
        if (checkDiagonal(player) || checkAntiDiagonal(player)) {
            return true;
        }
        return false;
    }

    private boolean checkRow(int row, char player) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == player) {
                count++;
            } else {
                count = 0;
            }
            if (count == winCondition) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int col, char player) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][col] == player) {
                count++;
            } else {
                count = 0;
            }
            if (count == winCondition) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(char player) {
        for (int i = 0; i <= size - winCondition; i++) { // Start from each possible start of a diagonal
            for (int j = 0; j <= size - winCondition; j++) {
                int count = 0;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i + k][j + k] == player) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == winCondition) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkAntiDiagonal(char player) {
        for (int i = 0; i <= size - winCondition; i++) { // Start from each possible start of an anti-diagonal
            for (int j = winCondition - 1; j < size; j++) {
                int count = 0;
                for (int k = 0; k < winCondition; k++) {
                    if (board[i + k][j - k] == player) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == winCondition) {
                    return true;
                }
            }
        }
        return false;
    }

    // Utility to check if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '\u0000') { // Assuming unset squares are represented by null character or similar
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameDraw() {
        return !checkWin('X') && !checkWin('O') && isBoardFull();
    }

	public static void main(String[] args) {
	}
}