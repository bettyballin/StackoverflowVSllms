import org.apache.commons.text.StringEscapeUtils;

public class HtmlConverter {
    public static String convertHtmlToPlainText(String html) {
        return StringEscapeUtils.unescapeHtml4(html);
    }

    public static void main(String[] args) {
        String html = "<p>Hello, World!</p>";
        System.out.println(convertHtmlToPlainText(html));
    }
}