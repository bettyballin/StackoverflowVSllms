import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class HtmlSanitizer {
    public static void main(String[] args) {
        // Define allowed HTML tags and attributes
        PolicyFactory policy = new HtmlPolicyBuilder()
            .allowElements("p", "span", "strong", "em")
            .allowAttributes("style").onElements("span")
            .toFactory();

        // Define user input
        String userInput = "<p>Hello <span style='color: blue'>World!</span></p><script>alert('XSS')</script>";

        // Sanitize user input
        String sanitizedHtml = policy.sanitize(userInput);

        // Print sanitized HTML
        System.out.println(sanitizedHtml);
    }
}