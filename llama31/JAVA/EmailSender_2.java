import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Properties;

public class EmailSender_2 {
    public static void main(String[] args) throws MessagingException, IOException {
        // Create a mail session
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props);

        // Define the email template
        String emailBody = "<html><body>Hello, <b>World!</b></body></html>";

        // Create a MimeMessage
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from@example.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("to@example.com"));
        message.setSubject("Email with template");
        message.setContent(emailBody, "text/html");

        // Send the email
        Transport.send(message);
    }
}