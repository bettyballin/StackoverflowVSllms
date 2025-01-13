import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class IMAPFolderCreator {
    private Store store;
    private Session session;
    private MyMailFolderListener myMailFolderListener;

    public IMAPFolderCreator(Session session, MyMailFolderListener myMailFolderListener) {
        this.session = session;
        this.myMailFolderListener = myMailFolderListener;
    }

    public boolean createFolder(String folderName) throws MessagingException {
        store = session.getStore("imap");
        System.out.println("connecting store..");
        store.connect("imap.gmail.com", 993, "something@gmail.com", "password");
        System.out.println("connected !");

        Folder defaultFolder = store.getDefaultFolder();

        return createFolder(defaultFolder, folderName);
    }

    private boolean createFolder(Folder parent, String folderName) {
        boolean isCreated = true;

        try {
            parent.open(Folder.READ_WRITE);
            System.out.println("adding listeners...");
            parent.addFolderListener(myMailFolderListener);
            System.out.println("creating a folder ....");
            Folder testFolder = parent.getFolder(folderName);

            isCreated = testFolder.create(Folder.HOLDS_MESSAGES);
            System.out.println("created: " + isCreated);
            parent.close(true);
        } catch (Exception e) {
            System.out.println("Error creating folder: " + e.getMessage());
            isCreated = false;
        }
        return isCreated;
    }

    public static void main(String[] args) {
        // You need to create a Session and a MyMailFolderListener instance
        // and pass them to the IMAPFolderCreator constructor
        // For example:
        // Session session = Session.getInstance(new Properties());
        // MyMailFolderListener myMailFolderListener = new MyMailFolderListener();
        // IMAPFolderCreator creator = new IMAPFolderCreator(session, myMailFolderListener);
        // creator.createFolder("testFolder");
    }
}

class MyMailFolderListener {
    // You need to implement the methods of the FolderListener interface
    // For example:
    public void folderCreated(FolderEvent e) {
        System.out.println("Folder created: " + e.getFolder().getName());
    }

    public void folderDeleted(FolderEvent e) {
        System.out.println("Folder deleted: " + e.getFolder().getName());
    }

    public void folderRenamed(FolderEvent e) {
        System.out.println("Folder renamed: " + e.getFolder().getName());
    }
}