import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputValidator_3 {

    // Regular expression to validate email addresses (simplified example)
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty() || email.length() > 100) {
            return false;
        }
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public static String sanitizeInput(String input) {
        if (input == null) return "";
        // Remove dangerous tags or characters
        return input.replaceAll("<script>", "").replaceAll("</script>", "")
                    .replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    public static void main(String[] args) {
        String userInput = "<script>alert('xss');</script>";
        if (isValidEmail(userInput)) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
        String sanitizedInput = sanitizeInput(userInput);
        System.out.println("Sanitized Input: " + sanitizedInput);
    }
}