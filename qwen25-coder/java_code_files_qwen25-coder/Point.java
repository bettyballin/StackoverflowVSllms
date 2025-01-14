import java.lang.String;

public class Point {
    private int x;
    private int y;

    public Point() {} // Default constructor needed for reflection

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters and setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public static void main(String[] args) {
    }
}