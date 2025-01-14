import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HyperSudokuGenerator {
    private static final int SIZE = 4; // Dimension for a 4x4x4 Sudoku
    private int[][][][] board = new int[SIZE][SIZE][SIZE][SIZE];
    private Random random = new Random();

    public void generate() {
        if (!solve(0, 0, 0, 0)) {
            throw new IllegalStateException("Failed to generate a valid HyperSudoku board");
        }
    }

    // This method attempts to solve starting from (x, y, z, w)
    private boolean solve(int x, int y, int z, int w) {
        if (w == SIZE) {
            if (z + 1 < SIZE) {
                return solve(x, y, z + 1, 0);
            } else if (y + 1 < SIZE) {
                return solve(x, y + 1, 0, 0);
            } else if (x + 1 < SIZE) {
                return solve(x + 1, 0, 0, 0);
            } else {
                return true; // Solved
            }
        }

        Set<Integer> possibleNumbers = getPossibleNumbers(x, y, z, w);

        while (!possibleNumbers.isEmpty()) {
            int num = removeRandom(possibleNumbers);
            board[x][y][z][w] = num;
            if (solve(x, y, z, w + 1)) {
                return true; // Solution found
            }
            board[x][y][z][w] = 0; // Backtrack
        }

        return false; // Trigger backtracking
    }

    private int removeRandom(Set<Integer> set) {
        int index = random.nextInt(set.size());
        int i = 0;
        Integer numberToRemove = null;
        for (int n : set) {
            if (i == index) {
                numberToRemove = n;
                break;
            }
            i++;
        }
        if (numberToRemove != null) {
            set.remove(numberToRemove);
            return numberToRemove;
        } else {
            throw new IllegalStateException("Error removing element from set");
        }
    }

    private Set<Integer> getPossibleNumbers(int x, int y, int z, int w) {
        Set<Integer> possible = new HashSet<>();
        for (int i = 1; i <= SIZE * SIZE; i++) {
            possible.add(i);
        }

        // Check row
        removeFromSet(possible, board[x][y][z]);

        // Check column
        removeFromSet(possible, board);

        // Check subgrid in current layer
        int startZ = z / SIZE * SIZE;
        int startW = w / SIZE * SIZE;
        for (int i = 0; i < SIZE; i++) {
            removeFromSet(possible, board[x][y][startZ + i][startW]);
        }

        return possible;
    }

    private void removeFromSet(Set<Integer> set, int[] arr) {
        for (int num : arr) {
            set.remove(num);
        }
    }

    private void removeFromSet(Set<Integer> set, int[][][][] grid) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                for (int z = 0; z < SIZE; z++) {
                    for (int w = 0; w < SIZE; w++) {
                        set.remove(grid[x][y][z][w]);
                    }
                }
            }
        }
    }

    private void removeFromSet(Set<Integer> set, int[][] arr) {
        for (int[] row : arr) {
            for (int num : row) {
                set.remove(num);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println("Layer " + i);
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    for (int l = 0; l < SIZE; l++) {
                        System.out.print(board[i][j][k][l] + " ");
                    }
                    System.out.print("| ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HyperSudokuGenerator generator = new HyperSudokuGenerator();
        generator.generate();
        generator.printBoard();
    }
}