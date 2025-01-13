import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;

public class ImapFetchMessagesSinceDate {
    public static void main(String[] args) throws Exception {
        // Set up IMAP connection
        Properties props = new Properties();
        props.setProperty("mail.imap.host", "imap.example.com");
        props.setProperty("mail.imap.port", "143");
        props.setProperty("mail.imap.starttls.enable", "true");

        Session session = Session.getInstance(props);
        Store store = session.getStore("imap");
        store.connect("username", "password");

        // Select folder
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        // Set search term for messages since a specific date
        Date sinceDate = new Date(System.currentTimeMillis() - 86400000); // 1 day ago
        SearchTerm term = new ReceivedDateTerm(ComparisonTerm.GT, sinceDate);

        // Fetch messages
        Message[] messages = folder.search(term);

        // Process messages
        for (Message message : messages) {
            System.out.println(message.getSubject());
        }

        // Clean up
        folder.close(false);
        store.close();
    }
}