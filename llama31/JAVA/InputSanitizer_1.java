import java.lang.String;
import java.util.regex.Pattern;

// Define the custom exception class
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class InputSanitizer_1_1 {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public static String sanitizeEmail(String input) throws InvalidInputException {
        if (EMAIL_PATTERN.matcher(input).matches()) {
            return input;
        } else {
            throw new InvalidInputException("Invalid email format");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(sanitizeEmail("test@example.com"));
            System.out.println(sanitizeEmail("invalid-email"));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}