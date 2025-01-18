import java.awt.Point;

public class ImageAnalyzer {
    private Point getCentroid(BitmapData bitmap) {
        int totalX = 0, numPoints = 0;
        double averageX = 0f;
        int iy = bitmap.height() / 2; // Fixed y coordinate

        for (int ix = 0, w = bitmap.width(); ix < w; ix++) {
            if (!bitmap.getPixel(ix, iy)) continue; // Skip empty pixels.
            totalX += ix;
            numPoints++;
        }

        averageX = (double) totalX / numPoints;
        return new Point((int) Math.round(averageX), iy);
    }

    public static void main(String[] args) {
    }
}

class BitmapData {
    public int width() {
        return 0;
    }

    public int height() {
        return 0;
    }

    public boolean getPixel(int x, int y) {
        return false;
    }
}