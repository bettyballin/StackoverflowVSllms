import java.lang.String;
public class ArrayTraversal {
    private static int N = 5; // Size of the array
    private static int MAX_MOVES = 10; // Maximum number of moves before resetting

    public static void main(String[] args) {
        boolean[][] visited = new boolean[N][N];
        visit(2, 2, 0, visited); // Starting from the middle (assuming odd N)
    }

    private static void visit(int x, int y, int moves, boolean[][] visited) {
        if (moves == MAX_MOVES) {
            // Reset to starting point or handle completion
            System.out.println("Reset at: " + x + ", " + y);
            return;
        }

        if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y]) {
            return; // Out of bounds or already visited
        }

        visited[x][y] = true;
        System.out.println("Visiting: " + x + ", " + y);

        // Explore neighbors in all four directions
        visit(x - 1, y, moves + 1, visited); // Up
        visit(x + 1, y, moves + 1, visited); // Down
        visit(x, y - 1, moves + 1, visited); // Left
        visit(x, y + 1, moves + 1, visited); // Right

        // Backtrack
        visited[x][y] = false;
    }
}