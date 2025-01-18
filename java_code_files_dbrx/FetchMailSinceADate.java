// Import necessary libraries
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Date;

public class FetchMailSinceADate {
    public static void main(String[] args) throws Exception{
        String host = "imap.gmail.com"; // your imap mail server address here
        String email = "<your-email>"; // your specific email id
        String password = "<password>" ;// your password in this case I am giving the pass directly which IS NOT a good practice. Instead of directly putting it here, you should use some secure way to store and retrieve sensitive data like passwords such as environment variables or secrets managers.

        // Connect to email server using IMAP
        Properties properties = System.getProperties();
        properties.setProperty("mail.store.protocol", "imap");
        Session session = Session.getDefaultInstance(properties);
        Store store = session.getStore("imap");
        store.connect(host, email, password);

       // Fetch the inbox folder using IMAP commands
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Calendar recentTime = Calendar.getInstance(); // get today's date as reference
        recentTime.add(Calendar.DATE, -15);// retrieve emails 15 days old or younger - adjust this to your needs
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");// choose a compatible format for the recentTime object
        final Date dateObj = sdf.parse(sdf.format(recentTime.getTime())); // convert recentTime to date object, ready for comparison in IMAP search query

       // Use an IMAP SEARCH command with the since keyword followed by our chosen date
        SearchTerm newerThanDate = new SearchTerm() {
            @Override
            public boolean match(Message message) {
                try {
                    return message.getSentDate().after(dateObj);// any emails newer than this?
                } catch (MessagingException e) {
                    // log or handle Exception in production code!
                    System.out.println("Failed to parse email: " + e );
                    return false;
                }
            }
        };

       // Extract and print selected messages' info
        Message[] foundMessages = inbox.search(newerThanDate);// perform the search using our custom SearchTerm object
        for (Message message : foundMessages) {
            System.out.println("Subject: " + message.getSubject());
            System.out.println("Sent Date: " + message.getSentDate().toString());
            MimeBodyPart mbp =  (MimeBodyPart)message.getContent(); // assuming your email content is text/plain form, adjust as per actual format if otherwise
            String bodyText = mbp.getContent().toString() ;// get the message content itself here if needed
        }
    }
}