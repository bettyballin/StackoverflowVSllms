import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.EmailException;

public class SendEmail_3_3 {
    public static void main(String[] args) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("mydomain.com"); // not used if MX lookup is enabled
        email.setFrom("me@mydomain.com");
        email.addTo("you@yourdomain.com");
        email.setSubject("Test Email");
        email.setMsg("This is a test email");
        email.setUseMxLookup(true); // enable MX lookup
        email.send();
    }
}