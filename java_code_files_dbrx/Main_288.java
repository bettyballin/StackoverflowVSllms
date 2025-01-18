import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermissions;

public class Main {

    public static void setPermissions(String filePath, boolean recursive) {
        File file = new File(filePath);
        try {
            // Change permission to '755' using rwx notation
            Path path = file.toPath();
            Files.setPosixFilePermissions(path, PosixFilePermissions.fromString("rwxr-xr-x"));

            if (recursive && file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File child : files) {
                        setPermissions(child.getAbsolutePath(), true);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot change permissions of the given file: " + filePath);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // setPermissions("/path/to/file/or/directory", true);
    }
}