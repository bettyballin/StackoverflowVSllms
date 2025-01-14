import javax.mail.*;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;
import java.util.Properties;

public class GmailMessageProcessor {
    public static void main(String[] args) throws Exception {
        // Assuming 'session' is your MailSession object
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String host = "your_imap_host"; // e.g., "imap.gmail.com"
        String username = "your_username";
        String password = "your_password";

        Store store = session.getStore("imap");
        store.connect(host, username, password);
        Folder folder = store.getFolder("[Gmail]/Inbox"); // or any other relevant folder name
        folder.open(Folder.READ_WRITE);
        
        Flags processedFlag = new Flags("\\CustomFlag");
        
        Message[] messages = folder.search(new FlagTerm(new Flags(Flags.Flag.RECENT), true));
        for (int i = 0; i < messages.length; i++) {
            Message msg = messages[i];
            
            // Process your message here
            
            // Set a custom flag on the email to indicate it has been processed
            msg.setFlags(processedFlag, true);
        }
        
        // Later to fetch unprocessed messages:
        messages = folder.getMessages();
        for (int i = 0; i < messages.length; i++) {
            Message msg = messages[i];
            
            // Check if the message is marked as processed
            boolean isProcessed = msg.isSet(processedFlag);
            
            if (!isProcessed) {
                // Process your message here
                
                // Set a custom flag on the email to indicate it has been processed
                msg.setFlags(processedFlag, true);
            }
        }
        
        folder.close(true); // true to update remote message flags or folders on the server
        store.close();
    }
}