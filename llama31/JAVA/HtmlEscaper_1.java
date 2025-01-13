import java.lang.String;

public class HtmlEscaper_1_1 {
    public String escapeHtml(String input) {
        return input.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }

    public static void main(String[] args) {
        HtmlEscaper_1 escaper = new HtmlEscaper_1();
        System.out.println(escaper.escapeHtml("Hello, <b>World</b>!"));
    }
}