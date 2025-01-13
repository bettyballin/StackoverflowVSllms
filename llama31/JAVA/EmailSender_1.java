import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.MessagingException;

public class EmailSender_1_1 {
    public static void main(String[] args) throws MessagingException {
        Session session = Session.getDefaultInstance(System.getProperties());
        MimeMessage message = new MimeMessage(session);
        // ...
        System.out.println("Email content:");
        System.out.println(message.getContent());
    }
}