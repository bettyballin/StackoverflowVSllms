/*
 * Decompiled with CFR 0.152.
 */
public class Chessboard {
    private static final int BOARD_SIZE = 8;
    private Piece[][] board = new Piece[8][8];

    public Chessboard() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                this.board[i][j] = Piece.EMPTY;
            }
        }
    }

    public Piece getPiece(int n, int n2) {
        return this.board[n][n2];
    }

    public static void main(String[] stringArray) {
    }

    public static enum Piece {
        EMPTY,
        BLACK_PAWN,
        BLACK_KNIGHT,
        WHITE_PAWN,
        WHITE_KNIGHT;

    }
}
