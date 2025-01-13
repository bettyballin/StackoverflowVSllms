import java.io.File;
import javax.mail.Folder;

public class FolderManager {
    public static void main(String[] args) {
        Folder testFolder = new Folder(new File("path_to_your_folder")) {
            // Implement the necessary Folder methods
        };
        boolean isCreated = false;
        if (!testFolder.exists()) {
            isCreated = testFolder.create(Folder.HOLDS_MESSAGES);
        } else {
            System.out.println("Folder already exists");
        }
    }
}