import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;

public class StringAbbreviator {

    public static String abbreviate(String input, FontMetrics fm, int maxWidth) {
        if (fm.stringWidth(input) <= maxWidth) {
            return input; // No truncation needed
        }

        // Start abbreviating from the center
        int left = 0;
        int right = input.length();
        StringBuilder sb = new StringBuilder();

        while (left < right && fm.stringWidth(sb.toString()) < maxWidth - 3 * fm.charWidth('.')) {
            if (left % 2 == 0) {
                sb.insert(0, input.charAt(left++));
            } else {
                sb.append(input.charAt(--right));
            }
        }

        // Remove last character added to fit "..."
        if (sb.length() > 3) {
            sb.setLength(sb.length() - 1);
        }

        return sb.substring(0, (sb.length() / 2)) + "..." + sb.substring(sb.length() / 2);
    }

    public static void main(String[] args) {
        String text = "Hello world";
        int maxWidth = 50; // Example width

        // Create a dummy graphics context to get FontMetrics
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        Font f = new Font("Arial", Font.PLAIN, 12);
        FontMetrics fm = g.getFontMetrics(f);

        String abbreviatedText = abbreviate(text, fm, maxWidth);
        System.out.println("Original: " + text);
        System.out.println("Abbreviated: " + abbreviatedText);

        g.dispose();
    }
}