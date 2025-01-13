import java.lang.String;
public class ImageRotator {
    public static int[] rotateImage(int[] pixels, int width, int height, int degrees) {
        int[] rotatedPixels = new int[pixels.length];
        double angle = Math.toRadians(degrees);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        int centerX = width / 2;
        int centerY = height / 2;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixelIndex = y * width + x;
                int pixel = pixels[pixelIndex];

                // Calculate new coordinates
                int newX = (int) (centerX + (x - centerX) * cos - (y - centerY) * sin);
                int newY = (int) (centerY + (x - centerX) * sin + (y - centerY) * cos);

                // Check if new coordinates are within bounds
                if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                    int newPixelIndex = newY * width + newX;
                    rotatedPixels[newPixelIndex] = pixel;
                }
            }
        }

        return rotatedPixels;
    }

	public static void main(String[] args) {
	}
}