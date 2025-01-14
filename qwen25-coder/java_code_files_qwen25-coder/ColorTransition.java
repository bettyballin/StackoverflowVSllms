import java.lang.String;
public class ColorTransition {
    public static void main(String[] args) {
        int startColor = 0x00FF00; // Bright Green
        int endColor = 0xFF0000;   // Dark Red
        int durationHours = 240;   // Over 240 hours

        for (int hour = 0; hour <= durationHours; hour++) {
            float fraction = ((float) hour) / durationHours;
            int newColor = interpolateColor(startColor, endColor, fraction);
            System.out.printf("Hour %d: #%06X%n", hour, newColor);
        }
    }

    private static int interpolateColor(int startColor, int endColor, float fraction) {
        int startR = (startColor >> 16) & 0xFF;
        int startG = (startColor >> 8) & 0xFF;
        int startB = startColor & 0xFF;

        int endR = (endColor >> 16) & 0xFF;
        int endG = (endColor >> 8) & 0xFF;
        int endB = endColor & 0xFF;

        int r = (int) (startR + fraction * (endR - startR));
        int g = (int) (startG + fraction * (endG - startG));
        int b = (int) (startB + fraction * (endB - startB));

        return (r << 16) | (g << 8) | b;
    }
}