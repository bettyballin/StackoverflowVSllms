import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FolderScanner {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get("path/to/your/folder"); // replace with the path to your folder
        try (Stream<Path> paths = Files.walk(root)) {
            paths.filter(java.nio.file.Files::isRegularFile)
                 .forEach(System.out::println);
        }
    }
}