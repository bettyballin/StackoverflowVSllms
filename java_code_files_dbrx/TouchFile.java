import java.io.File;
import java.io.IOException;

public class TouchFile {

    private static final long FILE_EXPIRATION = 1000 * 60 * 60 * 24; // Example value (24 hours)

    public static void touch(String fileName) {
        File file = new File(fileName);
        try {
            long fileLastModifiedTime = file.lastModified();
            if (System.currentTimeMillis() - FILE_EXPIRATION > 0 && fileLastModifiedTime < System.currentTimeMillis() - FILE_EXPIRATION) { // Only change timestamp if it is older than desired expiration
                if (!file.exists()) {
                    file.createNewFile();
                }
                boolean success = file.setLastModified(System.currentTimeMillis());
                if (!success) {
                    System.out.println("Failed to update the last modified time for file: " + fileName);
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot touch the given file: " + fileName);
            e.printStackTrace();
        }
    }
}