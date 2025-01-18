import java.awt.Point;

public class TetrisFlyweightFactory {
    static final String TETROMINO_I = "I";

    public static TetrisPiece get(String tetrominoType, Point location) {
        // Assuming get method returns a TetrisPiece instance
        return new TetrisPiece(tetrominoType, location);
    }

    TetrisPiece pieceI = TetrisFlyweightFactory.get(TETROMINO_I, new Point(50, 10)); // get singleton

    public static void main(String[] args) {
        // Your code here
    }
}

class TetrisPiece {
    private String type;
    private Point location;

    public TetrisPiece(String type, Point location) {
        this.type = type;
        this.location = location;
    }

    // Additional methods and functionality as needed
}