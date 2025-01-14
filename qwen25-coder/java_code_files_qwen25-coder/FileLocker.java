import java.lang.String;
import java.io.File;
import java.io.IOException;

public class FileLocker {
    private static final String LOCK_FILE_EXTENSION = ".lock";

    public static boolean acquireLock(String filePath) throws IOException {
        File lockFile = new File(filePath + LOCK_FILE_EXTENSION);
        return !lockFile.exists() && lockFile.createNewFile();
    }

    public static void releaseLock(String filePath) {
        File lockFile = new File(filePath + LOCK_FILE_EXTENSION);
        if (lockFile.exists()) {
            lockFile.delete();
        }
    }

    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";
        try {
            if (acquireLock(filePath)) {
                // Perform file writing
                System.out.println("Lock acquired, write your data now.");
                // After writing is done
                releaseLock(filePath);
            } else {
                System.out.println("File is locked by another process or user.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}