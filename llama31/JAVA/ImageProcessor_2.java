public class ImageProcessor_2_2 {

    public static void processImage(int width, int height) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x < width / 2 && y < height / 2) {
                    int alpha = BilinearInterpolation.interpolate(x, y, width, height);
                    // Set the alpha value of the pixel to alpha
                    System.out.println("Alpha value at (" + x + ", " + y + ") is: " + alpha);
                }
            }
        }
    }

    public static void main(String[] args) {
        int width = 100;
        int height = 100;
        processImage(width, height);
    }
}

class BilinearInterpolation {
    public static int interpolate(int x, int y, int width, int height) {
        // implement the bilinear interpolation logic here
        return x + y; // placeholder logic
    }
}