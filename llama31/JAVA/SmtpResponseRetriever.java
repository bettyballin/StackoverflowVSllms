import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SmtpResponseRetriever {
    public static void main(String[] args) {
        String senderEmail = "your-email@gmail.com";
        String senderPassword = "your-password";
        String recipientEmail = "non-existent-email@example.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Test Email");
            message.setText("This is a test email");

            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close(); // Close the transport connection

            // Note: The TransportListener should be added before sending the message to capture events.
            // However, in your case, since you're looking for the response after sending, we'll keep it as is but remember,
            // for real-time event capture, add the listener before sending.

        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}