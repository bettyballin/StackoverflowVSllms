import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class TLSSender {
    public void sendEmail(String host, String port,
                          final String userName, final String password, String toAddress,
                          String subject, String message) throws MessagingException {

        // Set SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a Session instance with the specified properties and authenticator
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(userName, password);
            }
        });

        // Create a default MimeMessage object
        Message msg = new MimeMessage(session);

        // Set From: header field
        msg.setFrom(new InternetAddress(userName));

        // Set To: header field of the header.
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));

        // Set Subject: header field
        msg.setSubject(subject);

        // Set the actual message
        msg.setText(message);

        // Send message
        Transport.send(msg);
    }

    public static void main(String[] args) {
        TLSSender sender = new TLSSender();
        try {
            sender.sendEmail("smtp.example.com", "587",
                    "your-email@example.com", "your-password",
                    "recipient@example.com",
                    "Test Mail with TLS",
                    "Hello, this is a test email sent using JavaMail with TLS.");
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}