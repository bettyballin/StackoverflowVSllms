import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class FileCounter_1 {
    Path dirLocation = Paths.get("<directory_path>");
    long fileCount;

    {
        try {
            fileCount = Files.walk(dirLocation)
                             .filter((path) -> !Files.isDirectory(path))
                             .count();
            System.out.println("File Count: " + fileCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}