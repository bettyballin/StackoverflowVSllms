import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailReceiver {
    public static void main(String[] args) throws MessagingException {
        String host = "imap.gmail.com";
        String username = "your-email@gmail.com";
        String password = "your-password";

        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.ssl.trust", "*"); // Add this line to avoid SSL certificate issues

        Session session = Session.getDefaultInstance(props);
        Store store = session.getStore("imaps");
        store.connect(host, username, password);

        Folder inbox = store.getFolder("inbox");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        for (Message message : messages) {
            MimeMessage mimeMessage = (MimeMessage) message;
            System.out.println("Subject: " + mimeMessage.getSubject());
            System.out.println("From: " + mimeMessage.getFrom()[0]);
            System.out.println("Content: " + mimeMessage.getContent());
        }

        inbox.close(false);
        store.close();
    }
}