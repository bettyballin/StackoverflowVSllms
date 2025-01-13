import org.owasp.esapi.Validator;
import org.owasp.esapi.errors.ValidationException;
import org.owasp.esapi.ESAPI;

public class Sanitizer_21 {
    public static void main(String[] args) {
        String userInput = System.getProperty("userInput");

        try {
            Validator validator = ESAPI.validator();
            String sanitizedInput = validator.sanitize("sql", userInput);
            // Use sanitizedInput in your query
            System.out.println("Sanitized input: " + sanitizedInput);
        } catch (ValidationException e) {
            // Handle validation error
            System.err.println("Validation error: " + e.getMessage());
        }
    }
}