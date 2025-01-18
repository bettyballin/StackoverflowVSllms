import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Utf8ToAsciiConverter {

    public static String utf8toAscii(String input) {
        // Decompose and then compose with canonical mapping followed by a compatibility mapping, resulting in "normalized" output.
        String result = Normalizer.normalize(input, Normalizer.Form.NFKD);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length(); ) {
            int c = Character.codePointAt(result, i);

            // Keep only the base characters. Skip any variation selectors and diacritic marks.
            if (c >= Character.MIN_SUPPLEMENTARY_CODE_POINT && !Character.isIdentifierIgnorable(c)) {
                sb.appendCodePoint(c);
            } else if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                // Replaces all non-letter or digit with a space.
                sb.append(' ');
            } else {
                sb.appendCodePoint(c);
            }

            i += Character.charCount(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "Some input string with UTF-8 characters like ñ, ü, ā, etc.";
        String ascii = utf8toAscii(input);
        System.out.println(ascii);
    }
}