import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailValidator_8_8 {
    public static boolean isValidEmail(String email) {
        try {
            InternetAddress address = new InternetAddress(email);
            address.validate();
            return true;
        } catch (AddressException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("example@example.com")); // true
        System.out.println(isValidEmail("invalid_email")); // false
    }
}