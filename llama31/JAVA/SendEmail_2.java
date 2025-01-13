import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail_2 {
    public static void main(String[] args) throws MessagingException {
        // Set up the email server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", "25");

        // Create a new session with an authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("from@example.com", "password");
            }
        });

        // Create a new email message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("from@example.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@example.com"));
        msg.setSubject("Test Email");
        msg.setText("This is a test email");

        // Send the email
        Transport.send(msg);
    }
}