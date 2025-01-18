import java.lang.String;
import java.io.File;

public class FileDeleter {
    File file = new File("nonExistentFile");

    public FileDeleter() {
        if (!file.exists()) {
            System.out.println("The file does not exist.");
        } else {
            boolean success = file.delete();
            if (success) {
                System.out.println("The file has been deleted successfully.");
            } else {
                System.out.println("The file could not be deleted.");
            }
        }
    }

    public static void main(String[] args) {
        new FileDeleter();
    }
}