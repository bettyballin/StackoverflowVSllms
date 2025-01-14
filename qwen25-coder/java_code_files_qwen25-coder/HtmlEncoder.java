import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlEncoder {

    public String encodeForHTML(String untrusted) {
        return StringEscapeUtils.escapeHtml4(untrusted);
    }

    public static void main(String[] args) {
        // You can test the encodeForHTML method here
    }
}