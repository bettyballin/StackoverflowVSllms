/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public class ColorGenerator_1 {
    private static final Random random = new Random();
    private static final int MIN_RED = 100;
    private static final int MAX_RED = 220;
    private static final int MIN_GREEN = 120;
    private static final int MAX_GREEN = 240;
    private static final int MIN_BLUE = 150;
    private static final int MAX_BLUE = 250;

    public static int[] generateColor() {
        int n = random.nextInt(120) + 100;
        int n2 = random.nextInt(120) + 120;
        int n3 = random.nextInt(100) + 150;
        return new int[]{n, n2, n3};
    }

    public static void main(String[] stringArray) {
        for (int i = 0; i < 10; ++i) {
            int[] nArray = ColorGenerator_1.generateColor();
            System.out.println("RGB: (" + nArray[0] + ", " + nArray[1] + ", " + nArray[2] + ")");
        }
    }
}
