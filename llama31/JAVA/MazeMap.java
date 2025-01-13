import java.lang.String;

public class MazeMap {
    int[][] maze = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // 1 represents a wall
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}, // 0 represents an empty space
        {1, 0, 1, 1, 0, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public static void main(String[] args) {
        MazeMap mazeMap = new MazeMap();
        // You can add code here to utilize the mazeMap object
    }
}