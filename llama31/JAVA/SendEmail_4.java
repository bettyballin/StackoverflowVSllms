import org.subethasmtp.client.SMTPClient;
import org.subethasmtp.client.SMTPException;

public class SendEmail_4_4 {
    public static void main(String[] args) throws SMTPException {
        SMTPClient client = new SMTPClient();
        client.setFrom("me@mydomain.com");
        client.addTo("you@yourdomain.com");
        client.setSubject("Test Email");
        client.setBody("This is a test email");
        client.useMxLookup(true); // enable MX lookup
        client.send();
    }
}