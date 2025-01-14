// Example in Java: Server-side validation using Apache Commons Validator

public class EmailValidatorExample {
    public boolean validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static void main(String[] args) {
        EmailValidatorExample example = new EmailValidatorExample();
        String testEmail1 = "test@example.com";
        String testEmail2 = "invalid-email";
        System.out.println("Is '" + testEmail1 + "' a valid email? " + example.validateEmail(testEmail1));
        System.out.println("Is '" + testEmail2 + "' a valid email? " + example.validateEmail(testEmail2));
    }
}

// Simulated EmailValidator class since we don't have access to Apache Commons Validator
class EmailValidator {
    private static EmailValidator instance = new EmailValidator();

    public static EmailValidator getInstance() {
        return instance;
    }

    public boolean isValid(String email) {
        // Simple regex to validate email addresses
        if (email == null) {
            return false;
        }
        // Basic email validation regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }
}