import java.util.Set;
import java.util.HashSet;

public class MazePathFinder {
    private final int[][] maze;
    private final int n;
    private final Set<Integer> requiredValues;

    public MazePathFinder(int[][] maze, Set<Integer> requiredValues) {
        this.maze = maze;
        this.n = maze.length;
        this.requiredValues = new HashSet<>(requiredValues);
    }

    public boolean findPath(int x, int y, Set<Integer> visited) {
        if (x == n - 1 && visited.size() == n) {
            return true; // Reached the bottom with all values
        }
        if (!isValid(x, y, visited)) {
            return false;
        }

        visited.add(maze[x][y]);

        // Explore children: right, down, left (assuming bounds)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}};
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (findPath(newX, newY, new HashSet<Integer>(visited))) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(int x, int y, Set<Integer> visited) {
        return x >= 0 && x < n && y >= 0 && y < n 
            && !visited.contains(maze[x][y]) 
            && requiredValues.contains(maze[x][y]);
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 2, 5, 5, 4},
            {1, 5, 1, 3, 5},
            {4, 1, 2, 3, 2},
            {5, 5, 4, 4, 3},
            {4, 2, 1, 2, 4}
        };
        Set<Integer> requiredValues = new HashSet<>();
        for (int i = 1; i <= maze.length; i++) {
            requiredValues.add(i);
        }

        MazePathFinder solver = new MazePathFinder(maze, requiredValues);
        boolean result = solver.findPath(0, 0, new HashSet<Integer>());
        System.out.println("Path found: " + result);
    }
}