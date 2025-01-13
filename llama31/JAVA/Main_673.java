import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Main_673 {
    public static void main(String[] args) throws MessagingException {
        // Set up the SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Set up the session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your_email@example.com", "your_password");
            }
        });

        // Create the message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("your_email@example.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("recipient@example.com"));
        message.setSubject("Hello world!", "UTF-8");
        message.setText("Hello world!", "UTF-8");

        // Send the message
        Transport.send(message);
    }
}