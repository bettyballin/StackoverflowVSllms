import java.lang.String;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;

public class HtmlCleaner {
    public static String stripUnwantedAttributes(String html) {
        // Regular expression pattern for unwanted attributes (for "src" and "alt", add exception here if needed)
        final Pattern attributePattern = Pattern.compile("\\s+(?!href|src|alt)[^=]+=[^>]*");

        return Jsoup.parse(html).outerHtml().replaceAll(attributePattern.pattern(), "");
    }
    public static void main(String[] args) {
    }
}