import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.List;

public class EmailSender_5 {
    public static void main(String[] args) throws Exception {
        String recipient = "example@example.com";
        String subject = "Test Email";
        String body = "Hello, this is a test email.";

        // Resolve MX records
        List<String> mxRecords = DNSResolver.resolveMX(recipient.split("@")[1]);

        if (mxRecords.isEmpty()) {
            throw new Exception("No MX record found.");
        }

        String smtpServer = mxRecords.get(0);

        // Setup JavaMail session
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpServer);
        Session session = Session.getInstance(props, null);

        try (Transport transport = session.getTransport("smtp")) {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your-email@domain.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Use SMTP server found from MX record
            transport.connect(smtpServer);
            transport.sendMessage(message, message.getAllRecipients());
        }
    }

    static class DNSResolver {
        public static List<String> resolveMX(String domain) throws Exception {
            // Implement DNS resolution to get MX records here
            throw new UnsupportedOperationException("Implement MX record resolution logic.");
        }
    }
}