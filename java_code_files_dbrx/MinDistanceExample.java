public class MinDistanceExample {

    public static void main(String[] args) {
        int i = 5;  // Example value for i (should be greater than 1)
        int j = 2;  // Example index value for j

        double[][] l = new double[10][10]; // Initialize a 2D array l
        // Populate l with example values
        for (int m = 0; m < 10; m++) {
            for (int n = 0; n < 10; n++) {
                l[m][n] = Math.random(); // Assign random values for demonstration
            }
        }

        Point[] p = new Point[10]; // Initialize an array of Points
        // Populate p with example Points
        for (int m = 0; m < 10; m++) {
            p[m] = new Point(Math.random(), Math.random());
        }

        double min = Double.MAX_VALUE; // Initialize with maximum value
        for (int k = 1; k < i; ++k) {
            double tmp = l[k][i] + distance(p[k-1], p[j]); // assuming dist(pk, pj) is implemented as distance function
            if (tmp < min) {
                min = tmp;
            }
        }
        // min contains the minimum result.
        System.out.println("Minimum result is " + min);
    }

    public static double distance(Point a, Point b) {
        // Implementation of distance between two points
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static class Point {
        double x;
        double y;

        // Constructor for Point
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}