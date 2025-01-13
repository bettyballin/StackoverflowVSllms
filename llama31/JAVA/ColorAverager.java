import java.lang.String;

public class ColorAverager {
    public static int averageColors(int... colors) {
        int alpha = 0, red = 0, green = 0, blue = 0;

        for (int color : colors) {
            alpha += (color >> 24) & 0xFF;
            red += (color >> 16) & 0xFF;
            green += (color >> 8) & 0xFF;
            blue += color & 0xFF;
        }

        alpha /= colors.length;
        red /= colors.length;
        green /= colors.length;
        blue /= colors.length;

        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    public static void main(String[] args) {
        // Example usage:
        int color1 = 0xFF0000FF; // Red
        int color2 = 0xFF00FF00; // Green
        int color3 = 0xFF0000FF; // Blue

        int averageColor = averageColors(color1, color2, color3);
        System.out.println("Average color: " + Integer.toHexString(averageColor));
    }
}