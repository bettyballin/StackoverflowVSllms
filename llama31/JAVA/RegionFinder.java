import java.lang.String;
public class RegionFinder {
    public static int findRegion(double[] point, double[][] quadrilateral) {
        double[] v0 = subtract(quadrilateral[1], quadrilateral[0]);
        double[] v1 = subtract(quadrilateral[2], quadrilateral[0]);
        double[] v2 = subtract(point, quadrilateral[0]);

        double dot00 = dot(v0, v0);
        double dot01 = dot(v0, v1);
        double dot02 = dot(v0, v2);
        double dot11 = dot(v1, v1);
        double dot12 = dot(v1, v2);

        double invDenom = 1 / (dot00 * dot11 - dot01 * dot01);
        double u = (dot11 * dot02 - dot01 * dot12) * invDenom;
        double v = (dot00 * dot12 - dot01 * dot02) * invDenom;

        // Determine the region based on the barycentric coordinates
        if (u < 0 && v < 0) return 0; // Top-left
        if (u < 0 && v > 0 && v < 1) return 1; // Top-center
        if (u < 0 && v > 1) return 2; // Top-right
        if (u > 0 && u < 1 && v < 0) return 3; // Middle-left
        if (u > 0 && u < 1 && v > 0 && v < 1) return 4; // Middle-center
        if (u > 0 && u < 1 && v > 1) return 5; // Middle-right
        if (u > 1 && v < 0) return 6; // Bottom-left
        if (u > 1 && v > 0 && v < 1) return 7; // Bottom-center
        if (u > 1 && v > 1) return 8; // Bottom-right

        return -1; // Point is outside the quadrilateral
    }

    private static double[] subtract(double[] p1, double[] p2) {
        return new double[] { p1[0] - p2[0], p1[1] - p2[1] };
    }

    private static double dot(double[] v1, double[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1];
    }

	public static void main(String[] args) {
	}
}