import java.lang.String;
import java.util.Properties;
import javax.mail.*;
import javax.mail.event.*;

public class MailFolderCreator {
    private Session session;
    private Store store;
    private FolderListener myMailFolderListener;

    public boolean createFolder(String folderName) throws MessagingException {
        // Initialize session
        Properties props = new Properties();
        session = Session.getDefaultInstance(props);

        store = session.getStore("imap");
        System.out.println("connecting store...");
        // It's recommended to use OAuth2 for authentication instead of plain username and password
        store.connect("imap.gmail.com", 993, "something@gmail.com", "password");
        System.out.println("connected!");

        // Use an empty string to specify the root folder
        Folder rootFolder = store.getFolder("");

        return createFolder(rootFolder, folderName);
    }

    private boolean createFolder(Folder parent, String folderName) {
        boolean isCreated = true;

        try {
            if (!parent.isOpen()) {
                parent.open(Folder.READ_WRITE);
            }

            // Initialize the FolderListener
            myMailFolderListener = new FolderListener() {
                @Override
                public void folderCreated(FolderEvent e) {
                    System.out.println("Folder created: " + e.getFolder().getFullName());
                }

                @Override
                public void folderDeleted(FolderEvent e) {
                    System.out.println("Folder deleted: " + e.getFolder().getFullName());
                }

                @Override
                public void folderRenamed(FolderEvent e) {
                    System.out.println("Folder renamed: " + e.getFolder().getFullName());
                }
            };

            System.out.println("adding listeners...");
            parent.addFolderListener(myMailFolderListener);
            System.out.println("creating a folder...");
            Folder testFolder = parent.getFolder(folderName);

            isCreated = testFolder.create(Folder.HOLDS_MESSAGES);
            System.out.println("created: " + isCreated);
            if (parent.isOpen()) {
                parent.close(true);
            }
        } catch (Exception e) {
            System.out.println("Error creating folder: " + e.getMessage());
            isCreated = false;
        }
        return isCreated;
    }

    public static void main(String[] args) {
    }
}