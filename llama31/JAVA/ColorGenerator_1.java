import java.lang.String;
import java.util.Random;

public class ColorGenerator_1 {
    private static final Random random = new Random();

    // Define the range for each color component
    private static final int MIN_RED = 100;
    private static final int MAX_RED = 220;
    private static final int MIN_GREEN = 120;
    private static final int MAX_GREEN = 240;
    private static final int MIN_BLUE = 150;
    private static final int MAX_BLUE = 250;

    public static int[] generateColor() {
        int red = random.nextInt(MAX_RED - MIN_RED) + MIN_RED;
        int green = random.nextInt(MAX_GREEN - MIN_GREEN) + MIN_GREEN;
        int blue = random.nextInt(MAX_BLUE - MIN_BLUE) + MIN_BLUE;

        return new int[] { red, green, blue };
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] color = generateColor();
            System.out.println("RGB: (" + color[0] + ", " + color[1] + ", " + color[2] + ")");
        }
    }
}