import java.lang.String;

public class TicTacToeWinnerChecker {
    public boolean isWinner(char[][] board, char player) {
        int n = board.length;
        int winningLine = (n == 3) ? 3 : (n == 4) ? 4 : (n == 5) ? 5 : 0; // adjust for different board sizes

        // Check rows
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == winningLine) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (board[i][j] == player) {
                    count++;
                    if (count == winningLine) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Check diagonals
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (board[i][i] == player) {
                count++;
                if (count == winningLine) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (board[i][n - i - 1] == player) {
                count++;
                if (count == winningLine) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TicTacToeWinnerChecker checker = new TicTacToeWinnerChecker();
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };
        System.out.println(checker.isWinner(board, 'X')); // prints: true
    }
}