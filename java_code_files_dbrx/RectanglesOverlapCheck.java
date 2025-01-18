public class RectanglesOverlapCheck {
    public static void main(String[] args) {
        // Initialize rectangle 1 vertices (ptsR1)
        Point[] ptsR1 = new Point[4];
        ptsR1[0] = new Point(0, 0);
        ptsR1[1] = new Point(4, 0);
        ptsR1[2] = new Point(4, 2);
        ptsR1[3] = new Point(0, 2);

        // Initialize rectangle 2 vertices (ptsR2)
        Point[] ptsR2 = new Point[4];
        ptsR2[0] = new Point(1, 1);
        ptsR2[1] = new Point(5, 1);
        ptsR2[2] = new Point(5, 3);
        ptsR2[3] = new Point(1, 3);

        double[] intervalR1 = new double[2], intervalR2 = new double[2];
        double rmin, rmax; // for projection limits calculation
        boolean separated = false;

        for (int j = 0; j < 4; j++) {     // project all points of rectangle 1 onto the normal line at each edge n and edges on rectangle 2.
            // Compute normal vector of edge j of rectangle 1
            Point p1 = ptsR1[j];
            Point p2 = ptsR1[(j + 1) % 4];

            // Edge vector
            double edgeX = p2.x - p1.x;
            double edgeY = p2.y - p1.y;

            // Normal vector (rotated by 90 degrees)
            Point rABn = new Point(-edgeY, edgeX);

            // Normalize the normal vector
            double length = Math.sqrt(rABn.x * rABn.x + rABn.y * rABn.y);
            rABn.x /= length;
            rABn.y /= length;

            intervalR1[0] = Double.MAX_VALUE;
            intervalR1[1] = -Double.MAX_VALUE;
            for (int i = 0; i < 4; ++i) {  // project all vertices of R1 on the normal vector
                double prod = rABn.x * ptsR1[i].x + rABn.y * ptsR1[i].y;
                if (prod < intervalR1[0]) {
                    intervalR1[0] = prod; // min limit R1 on current edge normal line
                }
                if (prod > intervalR1[1]) {
                    intervalR1[1] = prod; // max limit R1 on current edge normal line
                }
            }

            // Repeat for second rectangle
            intervalR2[0] = Double.MAX_VALUE;
            intervalR2[1] = -Double.MAX_VALUE;
            for (int i = 0; i < 4; ++i) {  // project all vertices of R2 on the normal vector
                double prod = rABn.x * ptsR2[i].x + rABn.y * ptsR2[i].y;
                if (prod < intervalR2[0]) {
                    intervalR2[0] = prod; // min limit R2 on current edge normal line
                }
                if (prod > intervalR2[1]) {
                    intervalR2[1] = prod; // max limit R2 on current edge normal line
                }
            }

            // Check for separation
            if (intervalR1[1] < intervalR2[0] || intervalR2[1] < intervalR1[0]) {
                separated = true;
                System.out.println("Yes, Rectangles are separated");
                break;
            }
        } // end for loop edge of rectangle1

        if (!separated) {
            System.out.println("No, overlap is present.");
        }
    }
}

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}