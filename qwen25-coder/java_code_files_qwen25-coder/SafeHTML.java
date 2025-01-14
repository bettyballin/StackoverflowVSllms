import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

public class SafeHTML {
    public static String sanitize(String userInput) {
        PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        return policy.sanitize(userInput);
    }

    public static void main(String[] args) {
        String unsafeInput = "<script>alert('XSS')</script> <a href='http://example.com'>link</a>";
        String safeOutput = sanitize(unsafeInput);
        System.out.println(safeOutput);  // Output: " link"
    }
}