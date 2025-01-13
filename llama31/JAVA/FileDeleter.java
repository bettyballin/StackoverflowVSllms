import java.lang.String;
import java.io.File;
import java.io.IOException;

public class FileDeleter {
    public static void deleteFiles(String directory, String extension) {
        File dir = new File(directory);
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(extension)) {
                try {
                    if (file.delete()) {
                        System.out.println("Deleted file: " + file.getName());
                    } else {
                        System.out.println("Failed to delete file: " + file.getName());
                    }
                } catch (SecurityException e) {
                    System.out.println("Security exception occurred while deleting file: " + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        deleteFiles("/path/to/directory", ".gif");
    }
}