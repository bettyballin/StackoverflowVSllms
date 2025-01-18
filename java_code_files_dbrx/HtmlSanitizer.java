import java.lang.String;
import org.apache.commons.text.StringEscapeUtils;

public class HtmlSanitizer {
    String unsanitizedInput;
    String safeOutput = StringEscapeUtils.escapeHtml4(unsanitizedInput);
    public static void main(String[] args) {
    }
}