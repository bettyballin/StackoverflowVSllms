import java.lang.String;
public class SpiralMatrixTraversal {
    public static void traverse(int n, int m) {
        int x = 0, y = 0;
        int dx = 0, dy = 1;
        int[] bounds = {n, m};

        for (int i = 0; i < n * m; i++) {
            System.out.println("(" + x + ", " + y + ")");

            // Check if we need to change direction
            if (x + dx >= bounds[0] || x + dx < -bounds[0] ||
                y + dy >= bounds[1] || y + dy < -bounds[1]) {
                int temp = dx;
                dx = -dy;
                dy = temp;
            }

            x += dx;
            y += dy;
        }
    }

    public static void main(String[] args) {
        traverse(3, 3);
        traverse(5, 3);
    }
}