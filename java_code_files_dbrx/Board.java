import java.lang.String;
import java.lang.Integer;
import java.util.List;

public abstract class Board {
    // Piece status represented as an int array indexed by position on the board
    private int[] boardStatus; // -1 for empty space, 0-playerA, 1-playerB, etc

    // Store player pieces locations and possible moves
    public abstract List<Integer> availableMoves(int player);

    public static void main(String[] args) {
    }
}