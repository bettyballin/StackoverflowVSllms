import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailAddress {
    private final String address;

    public EmailAddress(String address) {
        if (!isValidEmail(address)) {
            throw new InvalidEmailException("Invalid email address");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public static boolean isValidEmail(String address) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(address);
        return matcher.matches();
    }

    // Define the custom exception class
    public static class InvalidEmailException extends RuntimeException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            EmailAddress email = new EmailAddress("example@example.com");
            System.out.println(email.getAddress());
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
    }
}