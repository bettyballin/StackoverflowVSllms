import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RectanglePlacer {
    private static class Rectangle {
        int x, y, width, height;

        Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public static List<Rectangle> placeRectangles(int panelWidth, int panelHeight, int numRectangles) {
        List<Rectangle> rectangles = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numRectangles; i++) {
            int width, height;
            do {
                width = random.nextInt(panelWidth / 2) + 1;
                height = random.nextInt(panelHeight / 2) + 1;
            } while (!isValidRectangle(rectangles, panelWidth, panelHeight, width, height));

            int x, y;
            do {
                x = random.nextInt(panelWidth - width);
                y = random.nextInt(panelHeight - height);
            } while (isOverlapping(rectangles, x, y, width, height));

            rectangles.add(new Rectangle(x, y, width, height));
        }

        return rectangles;
    }

    private static boolean isValidRectangle(List<Rectangle> rectangles, int panelWidth, int panelHeight, int width, int height) {
        return width > 0 && height > 0 && width <= panelWidth && height <= panelHeight;
    }

    private static boolean isOverlapping(List<Rectangle> rectangles, int x, int y, int width, int height) {
        for (Rectangle rectangle : rectangles) {
            if (x < rectangle.x + rectangle.width &&
                x + width > rectangle.x &&
                y < rectangle.y + rectangle.height &&
                y + height > rectangle.y) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int panelWidth = 800;
        int panelHeight = 600;
        int numRectangles = 10;

        List<Rectangle> rectangles = placeRectangles(panelWidth, panelHeight, numRectangles);
        for (Rectangle rectangle : rectangles) {
            System.out.println("x: " + rectangle.x + ", y: " + rectangle.y + ", width: " + rectangle.width + ", height: " + rectangle.height);
        }
    }
}