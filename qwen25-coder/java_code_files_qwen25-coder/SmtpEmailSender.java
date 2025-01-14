import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SmtpEmailSender {
    public static void main(String[] args) {
        // Example in Java (SMTP configuration)
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "localhost");
        properties.put("mail.smtp.port", "1025");
        
        Session session = Session.getInstance(properties);
        
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("from@example.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("to@example.com"));
            message.setSubject("Test Mail");
            message.setText("This is a test mail for development.");
            
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}