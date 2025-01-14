import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagExtractor {
    public static void main(String[] args) {
        String html = "<meta content='blogger' name='generator'/>";
        // The regex pattern to match the 'content' attribute value in <meta> tag
        Pattern pattern = Pattern.compile("<meta\\s+(?:[^>]*?\\s+)?name=['\"]generator['\"][^>]*?\\s+content=['\"]([^'\"]+)['\"][^>]*?>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            System.out.println("Generator: " + matcher.group(1));
        }
    }
}