import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleSyntaxHighlighter {

    // Example patterns, these should be more comprehensive in a real-world scenario
    private static final Pattern JAVA_KEYWORDS = Pattern.compile("\\b(abstract|assert|boolean|break|byte)+\\b", Pattern.CASE_INSENSITIVE);
    private static final Pattern XML_TAGS = Pattern.compile("<(\\/?)([^\\s>]+).*?>");

    public void highlight(String sourceCode) {
        Matcher keywordMatcher = JAVA_KEYWORDS.matcher(sourceCode);
        String highlightedCode = keywordMatcher.replaceAll(match -> "<span class='keyword'>" + match.group() + "</span>");

        Matcher tagMatcher = XML_TAGS.matcher(highlightedCode);
        highlightedCode = tagMatcher.replaceAll("<span class='tag'>$0</span>");

        System.out.println("Highlighted Code: " + highlightedCode); // Instead of println, update your editor view
    }

    public static void main(String[] args) {
        SimpleSyntaxHighlighter highlighter = new SimpleSyntaxHighlighter();
        String code = "public abstract class Example { int x; <tag>content</tag> }";
        highlighter.highlight(code);
    }
}