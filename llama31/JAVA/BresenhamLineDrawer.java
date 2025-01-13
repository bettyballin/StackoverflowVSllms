import java.lang.Math;

public class BresenhamLineDrawer {
    public void drawLine(int x1, int x2, int y1, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        // If line is steep, rotate by 90 degrees
        if (Math.abs(dy) > Math.abs(dx)) {
            // Swap x's and y's in subsequent operations
            int temp = x1;
            x1 = y1;
            y1 = temp;
            temp = x2;
            x2 = y2;
            y2 = temp;
            dx = x2 - x1;
            dy = y2 - y1;
        }

        // Line is not steep.  Use standard Bresenham algorithm
        int p = 2 * dy - dx;  // Decision variable
        int twoDy = 2 * dy;
        int twoDyDx = 2 * (dy - dx);

        for (int x = x1, y = y1; x <= x2; x++) {
            if (p < 0)
                p += twoDy;
            else {
                p += twoDyDx;
                y++;
            }

            setPixel(x, y);  // Set the pixel at (x, y)
        }
    }

    // Add a dummy implementation for setPixel method
    public void setPixel(int x, int y) {
        System.out.println("Setting pixel at (" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        BresenhamLineDrawer drawer = new BresenhamLineDrawer();
        drawer.drawLine(1, 10, 2, 8);
    }
}