import java.util.List;
import java.util.ArrayList;

public class Interpolation {

    public static double[] interpolate(double[] a1, double[] a2) {
        int n = a1.length + a2.length - 1;
        double[] result = new double[n];

        // List to store all points
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < a1.length; i++) {
            points.add(new Point(i, a1[i]));
        }
        for (int i = 0; i < a2.length; i++) {
            points.add(new Point(i, a2[i]));
        }

        // Sort points based on x value
        points.sort((p1, p2) -> Double.compare(p1.x, p2.x));

        double xIncrement = (points.get(points.size() - 1).x - points.get(0).x) / (n - 1);
        for (int i = 0; i < n; i++) {
            result[i] = interpolateAt(points, points.get(0).x + i * xIncrement);
        }

        return result;
    }

    private static double interpolateAt(List<Point> points, double x) {
        int i = 0;
        while (i < points.size() - 1 && points.get(i + 1).x <= x) {
            i++;
        }
        Point p0 = points.get(i);
        Point p1 = points.get(Math.min(i + 1, points.size() - 1));

        // Linear interpolation formula
        return p0.y + (p1.y - p0.y) * (x - p0.x) / (p1.x - p0.x);
    }

    private static class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        double[] a1 = {1, 4, 9, 16, 25, 36};
        double[] a2 = {6, 9, 14, 30};

        double[] result = interpolate(a1, a2);

        for (double value : result) {
            System.out.printf("%.4f ", value);
        }
    }
}