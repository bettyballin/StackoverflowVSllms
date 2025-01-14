import java.lang.String;
public class ImageRotator_1 {

    public static int[] rotateImage(int[] oldPixels, int width, int height, float degrees) {
        // Convert angle to radians
        double radians = Math.toRadians(degrees);

        // Create new image array (same size as original)
        int newWidth = width;
        int newHeight = height;
        int[] newPixels = new int[newWidth * newHeight];

        // Center of the image
        double centerX = width / 2.0;
        double centerY = height / 2.0;

        for (int y = 0; y < newHeight; ++y) {
            for (int x = 0; x < newWidth; ++x) {
                // Translate point back to origin
                double srcX = x - centerX;
                double srcY = y - centerY;

                // Rotate point
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double rotatedX = srcX * cos - srcY * sin;
                double rotatedY = srcX * sin + srcY * cos;

                // Translate point back to image coordinates
                rotatedX += centerX;
                rotatedY += centerY;

                // Round to nearest pixel
                int sourceX = (int) Math.round(rotatedX);
                int sourceY = (int) Math.round(rotatedY);

                if (sourceX >= 0 && sourceX < width && sourceY >= 0 && sourceY < height) {
                    newPixels[x + y * newWidth] = oldPixels[sourceX + sourceY * width];
                } else {
                    // Fill with background color or transparent pixel
                    newPixels[x + y * newWidth] = 0x00000000; // Transparent
                }
            }
        }

        return newPixels;
    }


	public static void main(String[] args) {
	}
}