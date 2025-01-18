import java.lang.String;
public class None_25 {

    static class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Vector {
        double x;
        double y;
        public Vector(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point A;
    static Point B;
    static Point C;
    static Point D;
    static Vector rAB;
    static Vector rBC;
    // similar for edges CD and DA on R1... then define unrotated edges on R2

    static {
        A = new Point(0, 0);
        B = new Point(1, 0);
        C = new Point(1, 1);
        D = new Point(0, 1);
        rAB = new Vector(B.x - A.x, B.y - A.y); // rotated edge AB
        rBC = new Vector(C.x - B.x, C.y - B.y);
        // similar for edges CD and DA on R1... then define unrotated edges on R2
    }

    public static void main(String[] args) {
    }
}