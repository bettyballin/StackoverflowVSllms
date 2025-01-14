import java.util.*;

public class CoinFlipGrid {
    private boolean[][] grid;
    private int n; // Grid size

    public CoinFlipGrid(boolean[][] initialGrid) {
        n = initialGrid.length;
        this.grid = new boolean[n][];
        for (int i = 0; i < n; i++) {
            this.grid[i] = initialGrid[i].clone();
        }
    }

    public void flip(int row, int col) {
        grid[row][col] = !grid[row][col];

        if (row - 1 >= 0) flipHelper(row - 1, col);
        if (row + 1 < n) flipHelper(row + 1, col);
        if (col - 1 >= 0) flipHelper(row, col - 1);
        if (col + 1 < n) flipHelper(row, col + 1);
    }

    private void flipHelper(int row, int col) {
        grid[row][col] = !grid[row][col];
    }

    public boolean isSolved() {
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                if (!cell) return false;
            }
        }
        return true;
    }

    // BFS to find the minimal number of flips
    public int minFlipsToWin() {
        Set<String> visited = new HashSet<>();
        Queue<Pair<CoinFlipGrid, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(this, 0));
        visited.add(toString());

        while (!queue.isEmpty()) {
            Pair<CoinFlipGrid, Integer> current = queue.poll();
            CoinFlipGrid currentState = current.getKey();
            int steps = current.getValue();

            if (currentState.isSolved()) {
                return steps;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Only flip when it's tails
                    if (!currentState.grid[i][j]) {
                        CoinFlipGrid newState = new CoinFlipGrid(currentState.grid);
                        newState.flip(i, j);
                        String stateString = newState.toString();

                        if (!visited.contains(stateString)) {
                            queue.offer(new Pair<>(newState, steps + 1));
                            visited.add(stateString);
                        }
                    }
                }
            }
        }
        return -1; // According to problem statement, unreachable
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                sb.append(cell ? "H" : "T");
            }
        }
        return sb.toString();
    }

    // Utility class to store pairs
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
    }
}