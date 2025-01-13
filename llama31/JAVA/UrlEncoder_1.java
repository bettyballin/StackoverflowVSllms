import org.apache.commons.text.StringEscapeUtils;

public class UrlEncoder_1_1 {
    public static void main(String[] args) {
        String userInputUrl = "https://example.com"; // Define userInputUrl
        String encodedUrl = StringEscapeUtils.escapeHtml4(userInputUrl);
        System.out.println(encodedUrl);
    }
}