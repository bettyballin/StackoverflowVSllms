import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHtmlData {
    public static void main(String[] args) {
        // Define the regular expression pattern
        Pattern pattern = Pattern.compile("<span id=\"important-data\">(.*?)</span>");

        // Get the HTML content
        String html = "// get the HTML content from the website"; // Replace this line with actual code to get the HTML

        // Create a matcher
        Matcher matcher = pattern.matcher(html);

        // Find the first match
        if (matcher.find()) {
            String data = matcher.group(1);
            System.out.println(data);
        }
    }
}