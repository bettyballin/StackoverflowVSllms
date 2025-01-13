import java.io.File;
import java.io.IOException;

public class FileLocker {
    public static void main(String[] args) {
        // Create a lock file
        File lockFile = new File("path/to/lockfile.lock");
        try {
            if (!lockFile.createNewFile()) {
                // Lock file already exists, abort
                System.out.println("Lock file already exists, aborting...");
                return;
            }
        } catch (IOException e) {
            System.err.println("Error creating lock file: " + e.getMessage());
            return;
        }

        // Write to the main file
        File mainFile = new File("path/to/mainfile.txt");
        // ... (your code to write to main file goes here)

        // Remove the lock file when done
        if (!lockFile.delete()) {
            System.err.println("Error deleting lock file");
        }
    }
}