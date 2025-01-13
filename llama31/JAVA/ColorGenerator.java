import java.lang.String;
public class ColorGenerator {

    public static void main(String[] args) {
        int[] targetColor = {255, 0, 0}; // Red
        int steps = 10;

        for (int i = 0; i <= steps; i++) {
            int[] color = interpolateColor(new int[]{255, 255, 255}, targetColor, (double) i / steps);
            System.out.println(String.format("RGB(%d, %d, %d)", color[0], color[1], color[2]));
        }
    }

    public static int[] interpolateColor(int[] startColor, int[] endColor, double fraction) {
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            result[i] = (int) (startColor[i] + (endColor[i] - startColor[i]) * fraction);
        }

        return result;
    }
}