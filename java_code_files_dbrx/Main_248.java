import java.util.ArrayList;
import java.util.List;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_248 {
    List<Point> getRelativePoints(Point p) {
        List<Point> points = new ArrayList<>();
        for (int i = -1; i <= 1; i++) { // change here -1 to whatever value you want. This is your offset
            for (int j = -1; j <= 1; j++) {   // same as above
                if (!(i == 0 && j == 0)) // this will eliminate center point from results
                    points.add(new Point(p.x + i, p.y + j));
            }
        }
        return points;
    }

    public static void main(String[] args) {
    }
}