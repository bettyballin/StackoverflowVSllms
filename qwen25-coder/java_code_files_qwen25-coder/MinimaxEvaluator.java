import java.util.List;
import java.util.ArrayList;

public class MinimaxEvaluator {
    // Pseudo-code for Minimax Algorithm on Tic-Tac-Toe
    public int minimax(TicTacToeBoard board, boolean maximizingPlayer) {
        if (board.isTerminal()) {
            return board.evaluate();
        }

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (TicTacToeMove move : board.getAvailableMoves()) {
                TicTacToeBoard newBoard = board.makeMove(move);
                int eval = minimax(newBoard, false);
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (TicTacToeMove move : board.getAvailableMoves()) {
                TicTacToeBoard newBoard = board.makeMove(move);
                int eval = minimax(newBoard, true);
                minEval = Math.min(minEval, eval);
            }
            return minEval;
        }
    }
    public static void main(String[] args) {
    }
}

class TicTacToeBoard {
    public boolean isTerminal() {
        return false; // stub implementation
    }
    public int evaluate() {
        return 0; // stub implementation
    }
    public List<TicTacToeMove> getAvailableMoves() {
        return new ArrayList<TicTacToeMove>(); // stub implementation
    }
    public TicTacToeBoard makeMove(TicTacToeMove move) {
        return new TicTacToeBoard(); // stub implementation
    }
}

class TicTacToeMove {
    // stub class
}