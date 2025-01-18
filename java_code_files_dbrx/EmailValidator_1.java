import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailValidator {

    public boolean validateEmail(String email) {
        try {
            InternetAddress internetAddress = new InternetAddress();
            // set the value of the address before validation
            internetAddress.setAddress(email);
            // The following will only validate format, not MX records etc.
            if (internetAddress == null) return false;
            internetAddress.validate();
        } catch (AddressException e) {
            return false;
        }
        return true;
    }

}