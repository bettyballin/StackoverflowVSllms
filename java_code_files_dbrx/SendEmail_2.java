import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class SendEmail {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(props);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from_email@example.com")); // replace with your email address
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("non-existing_email@example.com"));  // replace with invalid recipient email addresses
        message.setHeader("Disposition-Notification-To", "your_email@example.com"); // Your desired DSN response address
        message.addHeader("Return-Receipt-To", "your_email@example.com"); // Additional confirmation if supported by the mail client or server on other side.

        String smtpHost = "your.smtp.host";
        int smtpPort = 25; // Replace with your SMTP port
        String username = "your_username";
        String password = "your_password";

        Transport transport = session.getTransport();
        transport.connect(smtpHost, smtpPort, username, password);
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO)); // send the mail synchronously for each recipient

        transport.close();
    }
}