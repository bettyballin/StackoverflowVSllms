/*
 * Decompiled with CFR 0.152.
 */
public class PixelMatrix {
    private int[][] data;
    private int width;
    private int height;

    public PixelMatrix(int n, int n2) {
        this.width = n;
        this.height = n2;
        this.data = new int[n2][n];
    }

    public int get(int n, int n2) throws IndexOutOfBoundsException {
        if (n < 0 || n >= this.width || n2 < 0 || n2 >= this.height) {
            throw new IndexOutOfBoundsException();
        }
        return this.data[n2][n];
    }

    public static void main(String[] stringArray) {
        PixelMatrix pixelMatrix = new PixelMatrix(10, 10);
    }
}
