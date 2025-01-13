import java.util.*;

public class CoinFlipping {
    static final int SIZE = 4;

    static boolean[][] grid = new boolean[SIZE][SIZE];

    public static void main(String[] args) {
        // Initialize grid with some tails
        grid[0][1] = false;
        grid[1][1] = false;
        grid[2][2] = false;

        // Initialize the rest of the grid to heads
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == false) continue;
                grid[i][j] = true;
            }
        }

        // BFS search
        Queue<FlipSequence> queue = new LinkedList<>();
        queue.add(new FlipSequence());

        while (!queue.isEmpty()) {
            FlipSequence seq = queue.poll();
            if (isSolved()) {
                System.out.println("Solved in " + seq.length() + " flips");
                return;
            }

            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    if (!grid[row][col]) { // tails
                        FlipSequence newSeq = seq.append(new Flip(row, col));
                        queue.add(newSeq);
                        flip(row, col);
                    }
                }
            }
        }
    }

    static class Flip {
        int row, col;

        public Flip(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class FlipSequence {
        List<Flip> flips = new ArrayList<>();

        public FlipSequence append(Flip flip) {
            FlipSequence newSeq = new FlipSequence();
            newSeq.flips.addAll(flips);
            newSeq.flips.add(flip);
            return newSeq;
        }

        public int length() {
            return flips.size();
        }
    }

    static void flip(int row, int col) {
        // flip the coin at position (row, col) and its neighbors
        for (int i = Math.max(0, row - 1); i <= Math.min(SIZE - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(SIZE - 1, col + 1); j++) {
                grid[i][j] = !grid[i][j];
            }
        }
    }

    static boolean isSolved() {
        // check if all coins are heads
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!grid[i][j]) return false;
            }
        }
        return true;
    }
}