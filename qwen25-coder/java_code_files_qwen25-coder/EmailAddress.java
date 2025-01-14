import java.lang.String;
import java.util.regex.Pattern;

public class EmailAddress {
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String address;

    public EmailAddress(String address) throws IllegalArgumentException {
        if (!isValidEmail(address)) {
            throw new IllegalArgumentException("Invalid email address: " + address);
        }
        this.address = address;
    }

    private boolean isValidEmail(String emailStr) {
        return EMAIL_PATTERN.matcher(emailStr).matches();
    }

    public String getAddress() {
        return address;
    }

    // Additional methods for email manipulation can be added here

    public static void main(String[] args) {
    }
}

class Person {
    private EmailAddress emailAddress;

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }
}