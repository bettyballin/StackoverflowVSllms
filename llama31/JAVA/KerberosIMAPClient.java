import java.lang.String;
import java.lang.Set;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.util.Properties;
import java.net.URLName;

public class KerberosIMAPClient {
    public static void main(String[] args) throws Exception {
        // Set up Kerberos system properties
        System.setProperty("java.security.auth.login.config", "/path/to/krb5.conf");
        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");

        // Set up JavaMail properties
        Properties props = new Properties();
        props.setProperty("mail.imap.ssl.enable", "true");
        props.setProperty("mail.imap.sasl.enable", "true");
        props.setProperty("mail.imap.sasl.mechanisms", "GSSAPI");
        props.setProperty("mail.imap.auth.login.disable", "true");
        props.setProperty("mail.imap.auth.plain.disable", "true");

        // Create a new Session
        Session session = Session.getInstance(props);

        // Create a new IMAP store
        Store store = session.getStore("imaps");

        // Connect to the IMAP server
        store.connect("imap.example.com", "username", null);

        // Open the inbox
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // Process messages
        Message[] messages = inbox.getMessages();
        for (Message message : messages) {
            System.out.println(message.getSubject());
        }

        // Close the inbox and store
        inbox.close(false);
        store.close();
    }
}