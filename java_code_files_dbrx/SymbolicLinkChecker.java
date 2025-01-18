import java.nio.file.*;
import java.nio.file.attribute.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("your_file_path_here"); // Replace with your file path

        if (Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS).isSymbolicLink()) {
            // ...
        }
    }
}