import org.apache.commons.mail.MultiPartEmail;
import java.io.File;
import java.util.logging.Logger;

public class EmailSenderorEmailUtil {
    private static final Logger logger = Logger.getLogger(EmailSenderorEmailUtil.class.getName());

    public static void main(String[] args) throws Exception {
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("mail.myserver.com"); // specify the SMTP server to use
        email.addTo("jdoe@somewhere.org", "John Doe");
        email.addCC("cc@example.com"); // adds a CC recipient
        email.addBCC("bcc@example.com"); // adds a BCC recipient (only seeable in raw sources)
        email.setFrom("me@apache.org", "My Name");
        // Add email subject and body text
        email.setSubject("Some Subject");
        email.setMsg("Hello user.\nYour message goes here.");
        // Add an attachment using a File object
        email.attach(new File("/path/to/file.txt"), "Some optional description", "application/octet-stream");
        logger.info("Sending Email with attachment.");
        // Send the email
        email.send();
    }
}