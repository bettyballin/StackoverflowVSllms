import java.awt.Font;
import java.awt.FontMetrics;

public class StringTruncator {
    public static String truncateString(String original, Font font, int maxWidth) {
        FontMetrics metrics = new FontMetrics(font) {};
        int width = metrics.stringWidth(original);

        if (width <= maxWidth) {
            return original;
        }

        int truncateIndex = original.length() - 1;
        while (metrics.stringWidth(original.substring(0, truncateIndex) + "...") > maxWidth) {
            truncateIndex--;
        }

        return original.substring(0, truncateIndex) + "...";
    }

    public static void main(String[] args) {
        // Example usage:
        Font font = new Font("Arial", Font.PLAIN, 12);
        String original = "This is a very long string that needs to be truncated.";
        int maxWidth = 100;
        System.out.println(truncateString(original, font, maxWidth));
    }
}