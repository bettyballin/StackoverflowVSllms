import java.lang.String;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.DefaultAuthenticator;

public class GmailExample {
    public static void main(String[] args) throws EmailException {
        String[] recipients = {"receiver@gmail.com"};
        String sender = "sender@gmail.com";
        String password = "mypasswd";
        String host = "smtp.gmail.com";
        int port = 587; // Use 587 for TLS

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(host);
        email.setSmtpPort(port);
        email.setAuthenticator(new DefaultAuthenticator(sender, password));
        email.setTLS(true);
        email.setDebug(true);

        for (String recipient : recipients) {
            email.addTo(recipient);
        }

        email.setFrom(sender, "Me");
        email.setSubject("Test message");
        email.setMsg("This is a simple test of commons-email");
        email.send();
    }
}