import java.lang.String;
import com.google.common.net.InternetDomainName;

public class EmailValidator_5_5 {
    public static boolean isValidEmail(String email) {
        try {
            InternetDomainName.from(email);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidEmail("test@example.com")); // Expected: true
        System.out.println(isValidEmail("invalidEmail")); // Expected: false
    }
}