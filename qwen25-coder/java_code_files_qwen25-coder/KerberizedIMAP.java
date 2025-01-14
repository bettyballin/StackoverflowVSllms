import javax.mail.*;
import javax.security.auth.Subject;
import java.security.PrivilegedExceptionAction;
import java.util.Properties;
import javax.mail.URLName;

public class KerberizedIMAP {
    public static void main(String[] args) throws Exception {
        // Assuming you have already obtained a valid Kerberos ticket
        Subject subject = new Subject(); // Your Subject, likely from login context

        Session session = Session.getDefaultInstance(getMailServerProperties(),
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return null;
                    }
                });

        // Create the store connection using the session
        Store store = session.getStore(new URLName("imap", "imap.server.com", 993, "", null, null));

        // The next line will trigger GSSAPI authentication
        Subject.doAs(subject, (PrivilegedExceptionAction<Void>) () -> {
            store.connect();
            return null;
        });

        Folder folder = store.getFolder("[Gmail]/All Mail");
        folder.open(Folder.READ_ONLY);

        Message[] messages = folder.getMessages();

        for (Message message : messages) {
            System.out.println(message.getSubject());
        }

        folder.close(false);
        store.close();
    }

    private static Properties getMailServerProperties() {
        Properties properties = new Properties();
        properties.put("mail.imap.auth", "true");
        properties.put("mail.imap.starttls.enable", "true");
        properties.put("mail.imap.sasl.enable", "true");
        properties.put("mail.imap.sasl.mechanisms", "GSSAPI");
        properties.put("mail.imap.auth.mechanisms", "GSSAPI");
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");
        return properties;
    }
}