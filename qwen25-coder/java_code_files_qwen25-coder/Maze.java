import java.lang.String;

public class Maze {
    private boolean[][] layout; // true for wall, false for path

    public Maze() {
        layout = new boolean[21][19]; // Example size for original Pac-Man maze grid
        // Initialize walls in your 2D array here (set specific [y][x] to true)
        // For example, a few walls around the outer edges:
        for (int i = 0; i < layout.length; i++) {
            layout[i][0] = true; // Left wall
            layout[i][layout[0].length - 1] = true; // Right wall
        }
        for (int j = 0; j < layout[0].length; j++) {
            layout[0][j] = true; // Top wall
            layout[layout.length - 1][j] = true; // Bottom wall
        }
    }

    public void draw(java.awt.Graphics g) {
        int blockSize = 20; // Size of each block in pixels
        for (int y = 0; y < layout.length; y++) {
            for (int x = 0; x < layout[y].length; x++) {
                if (layout[y][x]) {
                    g.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}