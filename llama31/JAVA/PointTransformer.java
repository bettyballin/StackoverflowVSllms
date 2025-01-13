import java.lang.String;
import java.lang.Integer;

// Define the Point class
class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Define the Transform interface
interface Transform<T> {
    T read(String value) throws Exception;
    String write(T value) throws Exception;
}

public class PointTransformer implements Transform<Point> {

    @Override
    public Point read(String value) throws Exception {
        String[] parts = value.split(",");
        return new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    @Override
    public String write(Point value) throws Exception {
        return value.x + "," + value.y;
    }

    public static void main(String[] args) {
    }
}