import org.owasp.html.*;

public class Main_261 {
    public static void main(String[] args) throws Exception {
        final String safeHtml = new HtmlPolicyBuilder()
            .allowAttributes("src").globally().onElements("img") // allow img tag with src attribute only
            .toFactory().sanitize("<img onerror='alert(\"xss\");' src='#'>");
        System.out.println(safeHtml); // this will print "<img src="#">" which is safe and does not contain any script injection
    }
}