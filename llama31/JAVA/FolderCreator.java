import javax.mail.Folder;

public class FolderCreator {
    public static void main(String[] args) {
        FolderCreator folderCreator = new FolderCreator();
        folderCreator.createFolder();
    }

    public void createFolder() {
        String folderName = "testFolder"; // Define folderName
        Folder defaultFolder = null; // Initialize defaultFolder
        // You need to initialize defaultFolder with a valid Folder object
        // For example, using JavaMail API:
        // Session session = Session.getDefaultInstance(new Properties());
        // Store store = session.getStore();
        // store.connect();
        // defaultFolder = store.getDefaultFolder();

        Folder testFolder = defaultFolder.getFolder(folderName);
        boolean isCreated = testFolder.create(Folder.HOLDS_MESSAGES);
        System.out.println("Folder created: " + isCreated);
    }
}