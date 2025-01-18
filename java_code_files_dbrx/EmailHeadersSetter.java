import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailHeadersSetter {
    static Message message;
    static {
        try {
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props);
            message = new MimeMessage(session);
            message.setHeader("Disposition-Notification-To", "your_email@example.com");
            message.addHeader("Return-Receipt-To", "your_email@example.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}