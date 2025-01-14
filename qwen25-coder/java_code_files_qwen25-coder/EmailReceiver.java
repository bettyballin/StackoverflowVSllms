import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.util.Properties;

public class EmailReceiver {
    public static void main(String[] args) {
        // Set properties for the IMAP server
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");

        try {
            // Connect to an IMAP server
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("imaps");
            store.connect("imap.example.com", "username", "password");

            // Open the inbox folder
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // Get all new messages and iterate
            Message[] allMessages = emailFolder.getMessages();
            for (Message message : allMessages) {
                System.out.println("---------------------------------");
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);

                // Check if the mail has attachments
                if (message.isMimeType("multipart/*")) {
                    Multipart multiPart = (Multipart) message.getContent();
                    for (int j = 0; j < multiPart.getCount(); j++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(j);
                        if (!Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // Text message content
                            System.out.println("Message: " + part.getContent());
                        } else {
                            // Attachment processing code here...
                            System.out.println("Attachment File: " + part.getDataHandler().getName());
                        }
                    }
                } else if (message.isMimeType("text/plain")) {
                    // Plain text content
                    System.out.println("Text Message: " + message.getContent());
                }

            }

            // Close resources
            emailFolder.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}