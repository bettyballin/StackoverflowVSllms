import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender_1 {

    public void sendEmail(Session session, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your-email@example.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Test Mail");
            message.setText("This is a test mail");

            Transport.send(message);

            // Log the success
            System.out.println("Mail sent to " + recipient);
        } catch (MessagingException e) {
            // Log the failure
            System.err.println("Failed to send email to " + recipient + ": " + e.getMessage());

            // Here you can update your log file or take other actions
            updateFailureLog(recipient, e.getMessage());
        }
    }

    private void updateFailureLog(String recipient, String errorMessage) {
        // Code to update the log file with failure details
        System.out.println("Updating log for failed email: " + recipient + ", Error: " + errorMessage);
        // Implement your logging logic here
    }

    public static void main(String[] args) {
        // Initialize mail session and call sendEmail method
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your-email@example.com", "password");
            }
        });

        EmailSender_1 sender = new EmailSender_1();
        sender.sendEmail(session, "recipient@example.com");
    }
}