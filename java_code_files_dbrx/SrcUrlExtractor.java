import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SrcUrlExtractor {
    public static List<String> getSrcAttributesValues(String html) {
        // regular expression pattern for src URLs
        final Pattern urlPattern = Pattern.compile("src\\s*=\\s*['\"]([^'\"]*)");

        Matcher matcher = urlPattern.matcher(html);
        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            results.add(matcher.group(1)); // capturing group contains src values
        }
        return results;
    }
    public static void main(String[] args) {
    }
}