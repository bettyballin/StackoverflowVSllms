import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class KanaValidator {

    // Regex for Hiragana
    private static final String HIRAGANA_PATTERN = "[\\u3040-\\u309F]+";
    // Regex for Katakana including small kana letters
    private static final String KATAKANA_PATTERN = "[\\u30A0-\\u30FF]+";
    // Basic Kanji range, note this is not exhaustive but covers common usage
    private static final String KANJI_PATTERN = "[\\u4E00-\\u9FFF]+";

    public static boolean isValidHiragana(String input) {
        return matchesPattern(input, HIRAGANA_PATTERN);
    }

    public static boolean isValidKatakana(String input) {
        return matchesPattern(input, KATAKANA_PATTERN);
    }

    public static boolean isValidKanji(String input) {
        return matchesPattern(input, KANJI_PATTERN);
    }

    private static boolean matchesPattern(String input, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("Hiragana test: " + isValidHiragana("こんにちは")); // false
        System.out.println("Katakana test: " + isValidKatakana("コンバニチハ")); // true
        System.out.println("Kanji test: " + isValidKanji("こんにちは")); // false
    }
}