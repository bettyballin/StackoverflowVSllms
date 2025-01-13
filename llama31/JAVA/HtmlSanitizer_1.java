import org.owasp.esapi.Validator;
import org.owasp.esapi.errors.ValidationException;
import org.owasp.esapi.ESAPI;

public class HtmlSanitizer_1 {
    public static void main(String[] args) {
        // Define the allowed HTML tags and attributes
        String[] allowedTags = {"b", "i", "u"};
        String[] allowedAttributes = {"style"};

        // Input HTML to be sanitized
        String inputHtml = "<b>Hello</b> <script>alert('XSS')</script>";

        // Validate the input HTML
        Validator validator = ESAPI.validator();
        try {
            String sanitizedHtml = validator.sanitize("html", inputHtml, allowedTags, allowedAttributes);
            // Save the sanitized HTML to the database
            System.out.println("Sanitized HTML: " + sanitizedHtml);
        } catch (ValidationException e) {
            // Handle the validation error
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}