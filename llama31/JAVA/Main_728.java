import javax.mail.*;
import javax.mail.internet.*;

public class Main_728 {
    public static void main(String[] args) throws MessagingException {
        // Set up MailHog as a mock SMTP server
        String mailhogHost = "localhost";
        int mailhogPort = 1025;

        // Create a JavaMail session
        Properties props = new Properties();
        props.put("mail.smtp.host", mailhogHost);
        props.put("mail.smtp.port", mailhogPort);
        props.put("mail.smtp.auth", "false"); // add this line to disable authentication
        Session session = Session.getInstance(props);

        // Send an email using the mock SMTP server
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from@example.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("to@example.com"));
        message.setSubject("Test Email");
        message.setText("This is a test email");

        Transport.send(message);
    }
}