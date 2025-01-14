import java.lang.String;

public class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y= y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class ImmutablePointPrinter {
    public void printPoint(ImmutablePoint point) {
        System.out.println("X: " + point.getX() + ", Y: " + point.getY());
        // The following line would cause a compilation error because there's no setter method:
        // point.setX(10);
    }
    public static void main(String[] args) {
    }
}