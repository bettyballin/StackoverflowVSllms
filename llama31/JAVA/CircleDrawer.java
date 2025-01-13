import java.lang.String;

public class CircleDrawer {
    private boolean[][] grid; // added grid declaration

    public CircleDrawer(int gridSize) {
        this.grid = new boolean[gridSize][gridSize]; // initialize grid
    }

    public void drawCircle(int x, int y, int radius) {
        int d = 3 - 2 * radius;
        int x1 = 0;
        int y1 = radius;

        while (x1 <= y1) {
            plot(x + x1, y + y1);
            plot(x + x1, y - y1);
            plot(x - x1, y + y1);
            plot(x - x1, y - y1);
            plot(x + y1, y + x1);
            plot(x + y1, y - x1);
            plot(x - y1, y + x1);
            plot(x - y1, y - x1);

            if (d < 0) {
                d += 4 * x1 + 6;
            } else {
                d += 4 * (x1 - y1) + 10;
                y1--;
            }
            x1++;
        }
    }

    public void plot(int x, int y) {
        // Mark the grid cell at (x, y) as part of the circle
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            grid[x][y] = true;
        }
    }

    public static void main(String[] args) {
        CircleDrawer drawer = new CircleDrawer(100); // create a CircleDrawer instance
        drawer.drawCircle(50, 50, 20); // draw a circle
    }
}