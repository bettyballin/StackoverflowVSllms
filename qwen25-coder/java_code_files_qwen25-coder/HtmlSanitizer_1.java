import java.io.ByteArrayInputStream;
import org.w3c.tidy.Tidy;

public class HtmlSanitizer_1 {
    String postProcessedHtml;
    String html = ""; // Placeholder for the HTML content
    Tidy tidy = new Tidy();

    public HtmlSanitizer_1() {
        postProcessedHtml = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null).toString();
        // Replace &nbsp; with space
        postProcessedHtml = postProcessedHtml.replace("&nbsp;", " ");
    }

    public static void main(String[] args) {
        // You can create an instance of HtmlSanitizer_1 here if needed
    }
}