import java.lang.String;

public class ImageProcessor {
    public static void whiteBalance(int[] pixels) {
        int redSum = 0, greenSum = 0, blueSum = 0;
        for (int pixel : pixels) {
            redSum += (pixel >> 16) & 0xFF;
            greenSum += (pixel >> 8) & 0xFF;
            blueSum += pixel & 0xFF;
        }
        int numPixels = pixels.length;
        int redAvg = redSum / numPixels;
        int greenAvg = greenSum / numPixels;
        int blueAvg = blueSum / numPixels;
        int avg = (redAvg + greenAvg + blueAvg) / 3;
        for (int i = 0; i < numPixels; i++) {
            int red = (pixels[i] >> 16) & 0xFF;
            int green = (pixels[i] >> 8) & 0xFF;
            int blue = pixels[i] & 0xFF;
            red = Math.min(255, (int) (red * (double) avg / redAvg));
            green = Math.min(255, (int) (green * (double) avg / greenAvg));
            blue = Math.min(255, (int) (blue * (double) avg / blueAvg));
            pixels[i] = (red << 16) | (green << 8) | blue;
        }
    }

    public static void main(String[] args) {
    }
}