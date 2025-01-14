import java.lang.String;
import java.io.File;
import java.io.IOException;

public class DirectoryWriteCheck {

    public static boolean canWriteToDirectory(File directory) {
        if (!directory.exists() || !directory.isDirectory()) {
            return false;
        }
        
        File testFile = new File(directory, "testfile.tmp");
        try {
            // Attempt to create the file
            if (!testFile.createNewFile()) {
                // If it cannot be created, we do not have write access
                return false;
            }
        } catch (IOException e) {
            // Any exception means creation failed due to permission reasons or other IO issues
            return false;
        } finally {
            // Always clean up the test file if it was created
            if (testFile.exists()) {
                testFile.delete();
            }
        }
        // If we've reached here, the operation succeeded
        return true;
    }

    public static void main(String[] args) {
        File selectedDirectory = new File("/path/to/directory");
        boolean canWrite = canWriteToDirectory(selectedDirectory);
        if (canWrite) {
            System.out.println("You have write access to this directory.");
        } else {
            System.out.println("You do not have write access to this directory.");
        }
    }
}