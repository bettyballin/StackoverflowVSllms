import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class CustomizedHtmlSanitizer {
    private static final Safelist ALLOWED_TAGS = Safelist.basic()
        .addTags("a", "span")
        .addAttributes("a", "href"); // Only allow these tags for customization, you can add more depending upon your requirements.

    public String sanitize(String input) {
        return Jsoup.clean(input, ALLOWED_TAGS);
    }

    public static void main(String[] args) {
    }
}