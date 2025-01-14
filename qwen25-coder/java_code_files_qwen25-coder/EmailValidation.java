public class EmailValidation {
    public static void main(String[] args) {
        String email = "example@example.com";
        boolean isValid = EmailValidator.getInstance().isValid(email);
        System.out.println("Is the email valid? " + isValid);
    }
}

class EmailValidator {
    private static final EmailValidator instance = new EmailValidator();

    public static EmailValidator getInstance() {
        return instance;
    }

    public boolean isValid(String email) {
        // Simple regex pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}