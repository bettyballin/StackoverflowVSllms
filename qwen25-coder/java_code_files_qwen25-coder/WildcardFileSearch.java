import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.util.stream.Stream;

public class WildcardFileSearch {
    public static void main(String[] args) {
        // Define the directory and wildcard pattern
        Path dir = Paths.get("../");
        String globPattern = "glob:**/Test?/sample*.txt";

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(globPattern);

        try (Stream<Path> paths = Files.find(dir, Integer.MAX_VALUE,
                                             (path, attr) -> matcher.matches(path))) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}