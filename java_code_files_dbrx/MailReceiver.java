import java.lang.String;
import java.util.*;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class MailReceiver {
    public static void check(String host, String storeType, String user, String password) {
        try {
            // Get a session, set up properties
            Properties props = new Properties();
            props.setProperty("mail." + storeType + ".host", host);    // host = imap.example.com
            Session session = Session.getDefaultInstance(props, null);

            Store store = session.getStore(storeType);  // type=imaps or pop3s to connect securely
            store.connect();
        } /* ... */ catch (NoSuchProviderException ex) {
            System.out.println("No provider for " + storeType);
            throw new RuntimeException(ex);
        } catch (MessagingException ex) {
            System.out.println("Could not connect to" + storeType);
            throw new RuntimeException(ex);
        }
        // Process emails
        /* .... */
    }

    public static void main(String[] args) {
    }
}