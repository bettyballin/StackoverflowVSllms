import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class EmailValidator_3_3 {
    public static boolean isValidEmail(String email) {
        try {
            new Email(email);
            return true;
        } catch (EmailException e) {
            return false;
        }
    }

    public static void main(String[] args) {
    }
}