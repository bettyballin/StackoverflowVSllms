import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

public class TextProcessor {
    public static String removeWhitespaceInEncodedBoundaries(String input) {
        StringBuilder output = new StringBuilder();
        Pattern pattern = Pattern.compile("\\=\\?[^;]+?;Q\\?.+\\=");
        Matcher matcher = pattern.matcher(input);

        int prevEnd = 0;
        while (matcher.find()) {
            output.append(input, prevEnd, matcher.start())
                  .append(removeWhitespaceFromMatch(matcher, input));
            prevEnd = matcher.end();
        }

        if (prevEnd < input.length()) {
            output.append(input.substring(prevEnd)); // Append the remaining text outside of encoded boundaries
        }

        return output.toString();
    }

    private static String removeWhitespaceFromMatch(Matcher matcher, String input) {
        MatchResult result = matcher.toMatchResult();
        int start = result.start() + 2; // Skip '=?' and the charset part up to 'Q'
        int end = result.end() - 1;    // Don't include trailing '='

        return input.substring(start, end).replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
    }
}