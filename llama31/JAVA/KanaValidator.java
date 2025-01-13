import java.lang.String;
import java.util.regex.Pattern;

public class KanaValidator {
    private static final String HIRAGANA_REGEX = "\\p{InHiragana}+";
    private static final String KATAKANA_REGEX = "\\p{InKatakana}+";
    private static final String KANJI_REGEX = "\\p{InCJK_Unified_Ideographs}+";

    public boolean isHiragana(String input) {
        return Pattern.matches(HIRAGANA_REGEX, input);
    }

    public boolean isKatakana(String input) {
        return Pattern.matches(KATAKANA_REGEX, input);
    }

    public boolean isKanji(String input) {
        return Pattern.matches(KANJI_REGEX, input);
    }

	public static void main(String[] args) {
	}
}