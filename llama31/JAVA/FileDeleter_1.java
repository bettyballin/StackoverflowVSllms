import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDeleter_1 {
    public static void deleteFiles(String directory, String extension) {
        Path dir = Paths.get(directory);

        try {
            Files.list(dir)
                    .filter(file -> file.getFileName().toString().endsWith(extension))
                    .forEach(file -> {
                        try {
                            Files.deleteIfExists(file);
                            System.out.println("Deleted file: " + file.getFileName());
                        } catch (IOException e) {
                            System.out.println("Error deleting file: " + file.getFileName());
                        }
                    });
        } catch (IOException e) {
            System.out.println("Error listing files in directory");
        }
    }

    public static void main(String[] args) {
        deleteFiles("/path/to/directory", ".gif");
    }
}