import java.lang.String;
public class Chessboard {
    private static final int BOARD_SIZE = 8;
    private Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

    // Initialize the board with empty squares
    public Chessboard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
    }

    // Enum for piece types
    public enum Piece {
        EMPTY,
        BLACK_PAWN,
        BLACK_KNIGHT,
        // ...
        WHITE_PAWN,
        WHITE_KNIGHT,
        // ...
    }

    // Example method to get the piece at a specific position
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

	public static void main(String[] args) {
	}
}