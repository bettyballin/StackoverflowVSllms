import java.lang.String;

public enum CharacterWidth {
    NARROW(0.5),
    NORMAL(1.0),
    WIDE(1.5);

    private final double widthFactor;

    CharacterWidth(double widthFactor) {
        this.widthFactor = widthFactor;
    }

    public double getWidthFactor() {
        return widthFactor;
    }
}

public class TextWidthEstimator {
    private static final double AVERAGE_CHARACTER_WIDTH = 10.0; // adjust this value based on your font

    public static double estimateTextWidth(String text) {
        double width = 0.0;
        for (char c : text.toCharArray()) {
            CharacterWidth characterWidth = getCharacterWidth(c);
            width += characterWidth.getWidthFactor() * AVERAGE_CHARACTER_WIDTH;
        }
        return width;
    }

    private static CharacterWidth getCharacterWidth(char c) {
        // implement a mapping of characters to their corresponding CharacterWidth enum values
        // for simplicity, let's assume all characters are NORMAL width
        return CharacterWidth.NORMAL;
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        double estimatedWidth = estimateTextWidth(text);
        System.out.println("Estimated width of '" + text + "': " + estimatedWidth);
    }
}