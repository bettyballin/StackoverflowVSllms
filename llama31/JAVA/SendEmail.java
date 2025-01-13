import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "your-smtp-host");
        props.put("mail.smtp.port", "your-smtp-port");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your-username", "your-password");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your-from-email"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("your-to-email"));
            message.setSubject("Your email subject");
            message.setText("Your email body");

            Transport.send(message);
            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}