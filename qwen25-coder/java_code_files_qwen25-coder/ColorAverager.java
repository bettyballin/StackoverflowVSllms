import java.lang.String;
public class ColorAverager {
    public int averageARGB(int[] colors) {
        if (colors == null || colors.length != 5) {
            throw new IllegalArgumentException("Array must contain exactly five ARGB color integers.");
        }

        int alphaSum = 0;
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;

        for (int color : colors) {
            alphaSum += (color >> 24) & 0xFF;
            redSum += (color >> 16) & 0xFF;
            greenSum += (color >> 8) & 0xFF;
            blueSum += color & 0xFF;
        }

        int averageAlpha = alphaSum / 5;
        int averageRed = redSum / 5;
        int averageGreen = greenSum / 5;
        int averageBlue = blueSum / 5;

        return (averageAlpha << 24) | (averageRed << 16) | (averageGreen << 8) | averageBlue;
    }

    public static void main(String[] args) {
    }
}