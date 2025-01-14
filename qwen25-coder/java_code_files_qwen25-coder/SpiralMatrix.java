import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point)o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode(){
            return 31 * x + y;
        }
    }

    public static List<Point> getSpiralOrder(int N, int M) {
        List<Point> result = new ArrayList<>();
        if (N <= 0 || M <= 0) return result;

        // Start from the center of the matrix
        int x = (N - 1) / 2;
        int y = (M - 1) / 2;

        // Directions: right, down, left, up
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dirIndex = 0; // Start direction is right

        result.add(new Point(x, y)); // Add the starting point

        for (int i = 1; i < N * M; i++) {
            int nextX = x + directions[dirIndex][0];
            int nextY = y + directions[dirIndex][1];

            // Check if the next position is out of bounds or already visited
            if (!isValid(nextX, nextY, N, M) || result.contains(new Point(nextX, nextY))) {
                dirIndex = (dirIndex + 1) % 4; // Change direction
                nextX = x + directions[dirIndex][0];
                nextY = y + directions[dirIndex][1];
            }

            x = nextX;
            y = nextY;
            result.add(new Point(x, y));
        }

        return result;
    }

    private static boolean isValid(int x, int y, int N, int M) {
        return x >= -(N - 1) / 2 && x <= (N - 1) / 2 &&
               y >= -(M - 1) / 2 && y <= (M - 1) / 2;
    }

    public static void main(String[] args) {
        int N = 5, M = 3;
        List<Point> spiralOrder = getSpiralOrder(N, M);
        for (Point point : spiralOrder) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }
}