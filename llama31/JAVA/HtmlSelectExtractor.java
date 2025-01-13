import java.util.regex.Pattern;

public class HtmlSelectExtractor {
    String pattern = "<select[^>]*>(.*?)</select>";

    public HtmlSelectExtractor() {
        Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    }

    public static void main(String[] args) {
        new HtmlSelectExtractor();
    }
}