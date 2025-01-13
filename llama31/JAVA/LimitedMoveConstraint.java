import java.lang.String;
public class LimitedMoveConstraint {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] array;
    private boolean[][] visited;
    private int startX, startY;
    private int maxMoves;

    public LimitedMoveConstraint(int[][] array, int startX, int startY, int maxMoves) {
        this.array = array;
        this.startX = startX;
        this.startY = startY;
        this.maxMoves = maxMoves;
        this.visited = new boolean[array.length][array[0].length];
    }

    public void traverse() {
        dfs(startX, startY, 0);
    }

    private void dfs(int x, int y, int moves) {
        if (moves > maxMoves) {
            return;
        }
        visited[x][y] = true;
        // do something with array[x][y]
        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isValid(newX, newY) && !visited[newX][newY]) {
                dfs(newX, newY, moves + 1);
            }
        }
        visited[x][y] = false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < array.length && y >= 0 && y < array[0].length;
    }

	public static void main(String[] args) {
	}
}