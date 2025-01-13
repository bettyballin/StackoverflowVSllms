import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNormalizer {
    public static String normalize(String input) {
        // Remove special characters
        String clean = input.replaceAll("[^a-zA-Z0-9\\s_-]", "");

        // Split into words
        String[] words = clean.split("\\s|_|-");

        // Capitalize each word and remove leading numbers
        StringBuilder normalized = new StringBuilder();
        for (String word : words) {
            String capitalized = word.replaceAll("^\\d+", "").substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            normalized.append(capitalized);
        }

        return normalized.toString();
    }

    public static void main(String[] args) {
        System.out.println(normalize("the quick brown fox")); // TheQuickBrownFox
        System.out.println(normalize("the_quick_brown_fox")); // TheQuickBrownFox
        System.out.println(normalize("123The_quIck bROWN FOX")); // TheQuickBrownFox
        System.out.println(normalize("the_quick brown fox 123")); // TheQuickBrownFox123
        System.out.println(normalize("thequickbrownfox")); // Thequickbrownfox
    }
}