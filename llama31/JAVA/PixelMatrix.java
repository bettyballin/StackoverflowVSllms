import java.lang.String;

public class PixelMatrix {
    private int[][] data;
    private int width;
    private int height;

    public PixelMatrix(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = new int[height][width];
    }

    public int get(int x, int y) throws IndexOutOfBoundsException {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException();
        }
        return data[y][x];
    }

    public static void main(String[] args) {
        PixelMatrix matrix = new PixelMatrix(10, 10);
        // You can now use the matrix object
    }
}