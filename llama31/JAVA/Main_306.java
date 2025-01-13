import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.apache.commons.text.StringEscapeUtils;

public class Main_306_306 {
    public static void main(String[] args) {
        String encodedHtml = "&lt;p&gt;I need a regex or function that can remove the ENCODED HTML tags from a database record.&lt;/p&gt;";
        
        // Decode HTML entities
        String decodedHtml = StringEscapeUtils.unescapeHtml4(encodedHtml);
        
        // Remove HTML tags
        String plainText = decodedHtml.replaceAll("<.*?>", "");
        
        System.out.println(plainText);
    }
}