import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class TestEmail {
    public static void main(String[] args) throws MessagingException, InterruptedException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", 8085);

        Session session = Session.getInstance(props);

        MimeMessage mm = new MimeMessage(session);

        final String to = "to@example.com";
        final String from = "from@example.com";
        final String subject = "Email with Fake SMTP Server Test";
        final String body = "This is a test email using the fake SMTP server.";

        mm.setFrom(new InternetAddress(from));
        mm.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        mm.setSubject(subject);
        mm.setText(body);

        Transport transport = session.getTransport("smtp");
        try {
            transport.connect();
            Thread.sleep(1000); // give it a second to establish connection

            mm.saveChanges();
            transport.sendMessage(mm, mm.getAllRecipients());
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("Email sent to fake SMTP server.");
    }
}