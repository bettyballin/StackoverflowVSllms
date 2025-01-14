import java.lang.String;
public class PointRegionFinder {
    private static double distanceSquared(double x1, double y1, double x2, double y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }

    public static String findRegion(double qx1, double qy1, double qx2, double qy2, double qx3, double qy3, double qx4, double qy4, double px, double py) {
        // Calculate midpoints of each side
        double mx1 = (qx1 + qx2) / 2; double my1 = (qy1 + qy2) / 2;
        double mx2 = (qx2 + qx3) / 2; double my2 = (qy2 + qy3) / 2;
        double mx3 = (qx3 + qx4) / 2; double my3 = (qy3 + qy4) / 2;
        double mx4 = (qx4 + qx1) / 2; double my4 = (qy4 + qy1) / 2;

        // Check which region the point is in based on quadrant relative to midpoints
        boolean leftOfM1ToM3 = ((mx3 - mx1) * (py - my1) > (my3 - my1) * (px - mx1));
        boolean aboveM2ToM4 = ((px - mx4) * (my2 - my4) < (py - my4) * (mx2 - mx4));

        if (leftOfM1ToM3 && aboveM2ToM4) return "Top Left";
        else if (!leftOfM1ToM3 && aboveM2ToM4) return "Top Right";
        else if (!leftOfM1ToM3 && !aboveM2ToM4) return "Bottom Right";
        else if (leftOfM1ToM3 && !aboveM2ToM4) return "Bottom Left";

        // Further checks for the center regions
        double areaOfQuadrilateral = 0.5 * Math.abs(
            qx1 * (qy2 - qy4) + 
            qx2 * (qy3 - qy1) + 
            qx3 * (qy4 - qy2) + 
            qx4 * (qy1 - qy3)
        );

        double areaPX1X2M2 = 0.5 * Math.abs(px * (qy1 - my2) + qx1 * (my2 - py) + mx2 * (py - qy1));
        double areaPY2Y3M4 = 0.5 * Math.abs(py * (qx2 - qx3) + qy2 * (mx4 - px) + mx2 * (px - qy2));
        double areaPX3X4M1 = 0.5 * Math.abs(px * (qy3 - my1) + qx3 * (my1 - py) + mx4 * (py - qy3));

        if (areaPX1X2M2 + areaPY2Y3M4 <= areaOfQuadrilateral / 3.0 && areaPX3X4M1 <= areaOfQuadrilateral / 3.0) return "Center";

        leftOfM1ToM3 = ((mx3 - mx1) * (py - my1) < (my3 - my1) * (px - mx1));
        aboveM2ToM4 = ((px - mx4) * (my2 - my4) > (py - my4) * (mx2 - mx4));

        if (leftOfM1ToM3 && aboveM2ToM4) return "Left Center";
        else if (!leftOfM1ToM3 && aboveM2ToM4) return "Top Center";
        else if (!leftOfM1ToM3 && !aboveM2ToM4) return "Right Center";
        else return "Bottom Center"; // last option
    }

    public static void main(String[] args) {
        double qx1 = 0, qy1 = 0;
        double qx2 = 6, qy2 = 0;
        double qx3 = 9, qy3 = 4.5;
        double qx4 = 3, qy4 = 4.5;

        double px = 4, py = 2; // Example point

        System.out.println("Point is in region: " + findRegion(qx1, qy1, qx2, qy2, qx3, qy3, qx4, qy4, px, py));
    }
}