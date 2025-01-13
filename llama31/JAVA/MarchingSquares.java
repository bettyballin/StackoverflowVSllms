import java.util.List;
import java.util.ArrayList;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MarchingSquares {
    private int[][] image;
    private int width, height;

    public MarchingSquares(int[][] image) {
        this.image = image;
        this.width = image.length;
        this.height = image[0].length;
    }

    public List<Point> getContour() {
        List<Point> contour = new ArrayList<>();

        for (int y = 0; y < height - 1; y++) {
            for (int x = 0; x < width - 1; x++) {
                int squareIndex = getSquareIndex(x, y);
                if (squareIndex != 0 && squareIndex != 15) {
                    Point p1 = getPoint(x, y, squareIndex);
                    Point p2 = getPoint(x + 1, y, squareIndex);
                    contour.add(p1);
                    contour.add(p2);
                }
            }
        }

        return contour;
    }

    private int getSquareIndex(int x, int y) {
        int TL = image[x][y];
        int TR = image[x + 1][y];
        int BL = image[x][y + 1];
        int BR = image[x + 1][y + 1];

        return (TL << 3) | (TR << 2) | (BL << 1) | BR;
    }

    private Point getPoint(int x, int y, int squareIndex) {
        // calculate the point coordinates based on the square index
        // for demonstration purposes, a simple point is returned
        return new Point(x, y);
    }

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        MarchingSquares ms = new MarchingSquares(image);
        List<Point> contour = ms.getContour();
        for (Point p : contour) {
            System.out.println("Point: (" + p.x + ", " + p.y + ")");
        }
    }
}