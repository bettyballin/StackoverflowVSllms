import java.util.Arrays;

public class Solution {
    static class Point {
        int x, y;
    }

    static void sort(Point arr[], int n)
    {
        // Sort by X coordinate values first.
        Arrays.sort(arr, (a, b) -> {
            if (a.x != b.x) {
                return a.x - b.x;
            } else {
                return a.y - b.y;
            }
        });
    }

    static int distSq(Point p1, Point p2)
    {
        /* Return the square of Euclidean distance between points 'p1' and 'p2'. */
        return (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
    }

    static void convexHull(Point arr[], int n)
    {
        if (n < 3) return;   /* Case where at least three points are required to draw */
        sort(arr, n);            /* Sort array 'arr' in increasing order of X coordinate values.*/
        Point h[] = new Point[2 * n]; // Create a vector and create space for all 'n' vertices and another space needed when calculating convex polygon later on (extra buffer size for safety).

        int u = 0;     /* Upper Index of stack where we initially put first two points.*/
        int l = 1;  // Lower index from top to insert the remaining vertices
        h[u] = arr[0];
        h[l++] = arr[1];    // Push first two points into the stack and later pop unnecessary and invalid points.

        for (int i = 2; i < n; ++i) {   /* Process rest of the vertices from 'arr' */
            while ((l >= u +1) && (distSq(h[u], arr[i]) <= distSq(h[l - 1], arr[i]))) {
                --l;
            }
            // Discard top of stack and make current vertex 'arr[i]' as candidate for inclusion into final convex polygon
            u++;
            h[u] = arr[i]; // Insert the processed i'th vertex from array 'arr[]'. This will be included in our Final result as valid vertices forming Convex Hull.
        }
        System.out.print("Convex Hull Points: "); // Print final convex hull points which are part of polygon.
        for (int p = 0; p < u + 1; ++p)
            System.out.println("\n(" + h[p].x + "," + h[p].y + ")"); // Print all valid vertices forming Convex Hull in final result
    }

    public static void main(String[] args) {
        // Create sample points
        Point[] arr = new Point[5];
        arr[0] = new Point(); arr[0].x = 0; arr[0].y = 3;
        arr[1] = new Point(); arr[1].x = 2; arr[1].y = 2;
        arr[2] = new Point(); arr[2].x = 1; arr[2].y = 1;
        arr[3] = new Point(); arr[3].x = 2; arr[3].y = 1;
        arr[4] = new Point(); arr[4].x = 3; arr[4].y = 0;

        // Call convexHull
        convexHull(arr, arr.length);
    }
}