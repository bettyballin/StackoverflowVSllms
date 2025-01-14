public class MazeNavigator {
    private boolean[][] maze;

    private boolean canMove(int newX, int newY) {
        return !maze[newY][newX]; // Assuming true means wall
    }

    public static void main(String[] args) {
    }
}