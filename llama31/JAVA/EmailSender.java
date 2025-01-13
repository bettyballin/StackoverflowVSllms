import javax.mail.internet.MimeMessage;
import javax.mail.Session;

public class EmailSender {
    MimeMessage message;

    public EmailSender(Session session) {
        this.message = new MimeMessage(session);
        // ...
        message.setHeader("Content-Transfer-Encoding", "UTF-8");
    }

    public static void main(String[] args) {
        // Create a new session
        Session session = Session.getDefaultInstance(System.getProperties());
        
        // Create a new EmailSender
        EmailSender sender = new EmailSender(session);
    }
}