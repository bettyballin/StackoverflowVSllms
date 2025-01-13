import java.lang.String;

public class Main_156_156 {
  public static void main(String[] args) {
    int x1 = 0, y1 = 0;
    int x2 = 3, y2 = 0;
    int x3 = 2, y3 = 2;

    int minX = Math.min(x1, Math.min(x2, x3));
    int minY = Math.min(y1, Math.min(y2, y3));
    int maxX = Math.max(x1, Math.max(x2, x3));
    int maxY = Math.max(y1, Math.max(y2, y3));

    int count = 0;
    for (int x = minX; x <= maxX; x++) {
      for (int y = minY; y <= maxY; y++) {
        if (isPointInTriangle(x, y, x1, y1, x2, y2, x3, y3)) {
          count++;
        }
      }
    }

    System.out.println("Number of integer points within the triangle: " + count);
  }

  public static boolean isPointInTriangle(int x, int y, int x1, int y1, int x2, int y2, int x3, int y3) {
    boolean b1 = ((x - x1) * (y2 - y1) - (x2 - x1) * (y - y1)) < 0.0f;
    boolean b2 = ((x - x2) * (y3 - y2) - (x3 - x2) * (y - y2)) < 0.0f;
    boolean b3 = ((x - x3) * (y1 - y3) - (x1 - x3) * (y - y3)) < 0.0f;

    return ((b1 == b2) && (b2 == b3));
  }
}