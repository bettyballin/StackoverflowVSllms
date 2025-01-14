public class PointProximityChecker {
    public boolean isPointCloseToSegment(double Ax, double Ay, double Bx, double By, double Xx, double Xy, double d) {
        // Compute vectors BA and BX
        double BAx = Ax - Bx;
        double BAy = Ay - By;
        double BXx = Xx - Bx;
        double BXy = Xy - By;

        // Dot product BA * BX
        double dotProductBA_BX = BAx * BXx + BAy * BXy;
        
        // Check if point is beyond the endpoint B (use square of distance)
        if (dotProductBA_BX > 0) {
            return (BXx * BXx + BXy * BXy) < d * d;
        }

        // Compute vectors AB and AX
        double ABx = Bx - Ax;
        double ABy = By - Ay;
        double AXx = Xx - Ax;
        double AXy = Xy - Ay;

        // Dot product AB * AX
        double dotProductAB_AX = ABx * AXx + ABy * AXy;
        
        // Check if point is beyond the endpoint A (use square of distance)
        if (dotProductAB_AX > 0) {
            return (AXx * AXx + AXy * AXy) < d * d;
        }

        // Compute projection and perpendicular distance
        double projSquared = (BAx * BXx + BAy * BXy) * (BAx * BXx + BAy * BXy) / (BAx * BAx + BAy * BAy);
        double perpDistSquared = (BXx * BXx + BXy * BXy) - projSquared;
        
        // Check perpendicular distance against squared distance
        return perpDistSquared < d * d;
    }
    public static void main(String[] args) {
    }
}