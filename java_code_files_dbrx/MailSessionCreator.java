import java.util.Properties;
import javax.mail.Session;

public class MailSessionCreator {
    Properties props = new Properties();
    Session session;

    public MailSessionCreator() {
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); // Set to true for debug messages from JavaMail API
        session = Session.getDefaultInstance(props);
    }

    public static void main(String[] args) {
    }
}