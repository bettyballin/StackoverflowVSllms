import java.lang.String;
import java.awt.Point;

public class RectangleIntersection {
    /*
     * This function takes in two rectangle objects and returns whether they intersect each other or not. Each rectangle is defined by four sets of points (A, B, C, and D). Points are defined with their respective x and y coordinates.
     */
    public static boolean doRectangleIntersect(Point[] rect1, Point[] rect2) {
        // Define a boolean flag to determine if there's an intersection
        boolean intersect = false;

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                Point p1, p2; // Define two points used to represent the line segment of one rectangle
                if (i == 3) {
                    p1 = rect1[i];
                    p2 = rect1[0];
                } else {
                    p1 = rect1[i];
                    p2 = rect1[i + 1];
                }
                // Check if any point in second rectangle lies on line segment of first rectangle. If yes, then intersection is found and return true.
                for (Point r : rect2) {
                    if ((p2.y - p1.y) * (r.x - p1.x) - (p2.x - p1.x) * (r.y - p1.y) == 0) {
                        return true;
                    }
                }
            }
        }

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                Point p1, p2; // Define two points used to represent the line segment of other rectangle
                if (j == 3) {
                    p1 = rect2[j];
                    p2 = rect2[0];
                } else {
                    p1 = rect2[j];
                    p2 = rect2[j + 1];
                }
                // Check if any point in first rectangle lies on line segment of second rectangle. If yes, then intersection is found and return true.
                for (Point r : rect1) {
                    if ((p2.y - p1.y) * (r.x - p1.x) - (p2.x - p1.x) * (r.y - p1.y) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // You can add test cases here to test the doRectangleIntersect function.
    }
}