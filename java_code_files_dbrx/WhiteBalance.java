import java.lang.String;
public class WhiteBalance {
    public static int[] applyGrayWorld(int[] pixels) {
        long redSum = 0;
        long greenSum = 0;
        long blueSum = 0;

        final double totalPixels = pixels.length / 3;

        for (int i = 0; i < pixels.length; i += 3) { // Iterate through RGB channels
            redSum += pixels[i];
            greenSum += pixels[i + 1];
            blueSum += pixels[i + 2];
        }

        double redFactor = totalPixels / (redSum * 1.0);
        double greenFactor = totalPixels / (greenSum * 1.0);
        double blueFactor = totalPixels / (blueSum * 1.0);

        for(int i = 0; i < pixels.length; i += 3) { // Apply gain factors to each channel
            pixels[i] = (int)(pixels[i] * Math.min(4, redFactor));
            pixels[i + 1] = (int)(pixels[i + 1] * Math.min(4, greenFactor));
            pixels[i + 2] = (int)(pixels[i + 2] * Math.min(4, blueFactor));
        }

        return pixels;
    }

	public static void main(String[] args) {
	}
}