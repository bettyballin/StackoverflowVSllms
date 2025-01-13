import org.owasp.esapi.Validator;
import org.owasp.esapi.errors.ValidationException;
import javax.servlet.http.HttpServletRequest;

public class InputValidator_3 {
    public static void main(String[] args) {
        // This is just a placeholder to demonstrate compilation.
        // Real usage would involve integrating with a servlet or similar.
        String userInput = "exampleInput"; // Placeholder for user input

        try {
            Validator validator = ESAPI.validator();
            String sanitizedInput = validator.sanitize("userInput", userInput);
            System.out.println("Sanitized Input: " + sanitizedInput);
        } catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    // Example method for use in a servlet or JSP context
    public static String sanitizeInput(HttpServletRequest request) {
        String userInput = request.getParameter("userInput");
        try {
            Validator validator = ESAPI.validator();
            return validator.sanitize("userInput", userInput);
        } catch (ValidationException e) {
            // Handle validation error, possibly return null or throw exception
            return null;
        }
    }
}