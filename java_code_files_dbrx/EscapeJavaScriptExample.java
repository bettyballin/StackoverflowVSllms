import org.apache.commons.lang3.StringEscapeUtils;

public class EscapeJavaScriptExample {
    public static void main(String[] args) {
        // ...

        String html = "<script>alert('Hello, world!');</script>";
        html = StringEscapeUtils.escapeJavaScript(html);

        // ...

        System.out.println(html);
    }
}