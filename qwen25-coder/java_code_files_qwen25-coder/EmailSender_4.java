import java.lang.String;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender_4 {

    public void sendEmail() {
        try {
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.starttls.enable", "true"); // Use TLS for security
            props.put("mail.smtp.host", "smtp.somehost.com");
            props.put("mail.smtp.port", "587"); // Common port for TLS SMTP
            props.put("mail.smtp.auth", "true");

            Authenticator auth = new SMTPAuthenticator();

            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(System.getenv("EMAIL_FROM"))); // Use environment variables
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("recipient@somewhere.com"));
            msg.setSubject("yadayada");
            msg.setText("Yada yada");

            Transport.send(msg);

        } catch (MessagingException ex) {
            ex.printStackTrace();
            System.err.println("Error sending email: " + ex.getMessage());
        }
    }

    private static class SMTPAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(System.getenv("EMAIL_USER"), System.getenv("EMAIL_PASSWORD")); // Use environment variables
        }
    }

    public static void main(String[] args) {
    }
}