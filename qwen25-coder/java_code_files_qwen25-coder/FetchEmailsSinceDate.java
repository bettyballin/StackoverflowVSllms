import java.lang.String;
import javax.mail.*;
import javax.mail.search.AndTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.ComparisonTerm;
import java.util.Date;
import java.util.Properties;

public class FetchEmailsSinceDate {
    public static void main(String[] args) throws Exception {
        // Setup server properties
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

        // Get session
        Session session = Session.getDefaultInstance(props, null);

        // Connect to the store and folder
        Store store = session.getStore("imaps");
        store.connect("imap.example.com", "username", "password");
        Folder emailFolder = store.getFolder("INBOX");
        emailFolder.open(Folder.READ_ONLY);

        // Define the search term: emails sent since a specific date
        Date startDate = new Date(System.currentTimeMillis() - (10L * 24 * 60 * 60 * 1000)); // 10 days ago as an example
        SentDateTerm sdTerm = new SentDateTerm(ComparisonTerm.GT, startDate);

        // Search for messages and print them out
        Message[] foundMessages = emailFolder.search(sdTerm);

        for (Message message : foundMessages) {
            System.out.println("Found Message: " + message.getSubject());
        }

        // Close folder and store
        emailFolder.close(false);
        store.close();
    }
}