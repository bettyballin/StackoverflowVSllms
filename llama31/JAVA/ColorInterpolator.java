import java.lang.String;

public class ColorInterpolator {
    private static final int START_COLOR = 0x00FF00;
    private static final int END_COLOR = 0xFF0000;
    private static final int DURATION_HOURS = 240;

    public static int interpolateColor(int hours) {
        int red = interpolateComponent((END_COLOR >> 16) & 0xFF, (START_COLOR >> 16) & 0xFF, hours);
        int green = interpolateComponent((END_COLOR >> 8) & 0xFF, (START_COLOR >> 8) & 0xFF, hours);
        int blue = interpolateComponent(END_COLOR & 0xFF, START_COLOR & 0xFF, hours);

        return (red << 16) | (green << 8) | blue;
    }

    private static int interpolateComponent(int end, int start, int hours) {
        int range = end - start;
        float fraction = (float) hours / DURATION_HOURS;
        return start + (int) (range * fraction);
    }

    public static void main(String[] args) {
        for (int hours = 0; hours <= DURATION_HOURS; hours++) {
            int color = interpolateColor(hours);
            System.out.printf("%02X%02X%02X%n", (color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF);
        }
    }
}