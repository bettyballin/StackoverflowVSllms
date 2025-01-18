public class EdgeNormalComputer {
    Vector rAB = new Vector(1.0, 2.0); // arbitrary values
    Vector nAB = new Vector(-rAB.y, rAB.x); // normal vector for edge AB of R1
    // similar for other edges...

    public static void main(String[] args) {
    }
}

class Vector {
    public double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
}