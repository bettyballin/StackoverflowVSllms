import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    String to = "receiver@gmail.com"; //change accordingly
    final String user = "senderusername@outlook.com"; //change accordingly
    final String password = "<yourPassword>"; //change accordingly
    String userId = "userIdValue"; //change accordingly

    public EmailSender() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp-mail.outlook.com"); //for outlook
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        Message msg = new MimeMessage(session);
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject("Activation Email");
        msg.setText("Please Click on this link to validate your email: " + "www.xyz.com/activate/" + userId); //change accordingly

        Transport.send(msg);
    }

    public static void main(String[] args) {
        try {
            new EmailSender();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}