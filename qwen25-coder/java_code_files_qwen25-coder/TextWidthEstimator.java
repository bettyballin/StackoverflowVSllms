import java.util.HashMap;
import java.util.Map;

public class TextWidthEstimator {

    // Average relative width of characters in a typical proportional font (Arial, Helvetica).
    private static final Map<Character, Integer> CHAR_WIDTHS = new HashMap<>();

    static {
        for (char c : "iiiiiillll1111".toCharArray()) CHAR_WIDTHS.put(c, 1); // Narrow
        for (char c : "abcdefhjkpqrtuvyzABCDEFGHIKLMNPRTUVYZ23456789".toCharArray()) CHAR_WIDTHS.put(c, 2); // Normal
        for (char c : "mMW".toCharArray()) CHAR_WIDTHS.put(c, 3); // Wide

        // Add others as needed, setting defaults to 'normal' (width = 2)
    }

    private static final int CATEGORY_THRESHOLD_NARROW_NORMAL = 16;
    private static final int CATEGORY_THRESHOLD_NORMAL_WIDE = 32;

    public static String categorizeTextWidth(String text) {
        int totalWidth = 0;

        for (char c : text.toCharArray()) {
            totalWidth += CHAR_WIDTHS.getOrDefault(c, 2); // Default to normal width if not defined
        }

        if (totalWidth < CATEGORY_THRESHOLD_NARROW_NORMAL) {
            return "narrow";
        } else if (totalWidth < CATEGORY_THRESHOLD_NORMAL_WIDE) {
            return "normal";
        } else {
            return "wide";
        }
    }

    public static void main(String[] args) {
        String[] testStrings = {"iiiiiiii", "abcdefgh", "WWWWWWWW"};
        for (String s : testStrings) {
            System.out.println("String \"" + s + "\" is categorized as: " + categorizeTextWidth(s));
        }
    }
}