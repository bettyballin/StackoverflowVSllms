import org.owasp.esapi.Validator;
import org.owasp.esapi.errors.ValidationException;
import org.owasp.esapi.ESAPI;

public class Main_579 {
    public static void main(String[] args) {
        // Example using OWASP ESAPI
        Validator validator = ESAPI.validator();
        String url = "http://example.com";
        try {
            validator.isValidURL(url, "http", "https");
        } catch (ValidationException e) {
            // Handle invalid URL
            System.out.println("Invalid URL: " + e.getMessage());
        }
    }
}