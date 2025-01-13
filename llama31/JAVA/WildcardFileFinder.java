import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.PathMatcher;

public class WildcardFileFinder {
    public static void main(String[] args) throws IOException {
        String pattern = "../Test?/sample*.txt";
        PathMatcher matcher = Paths.get(pattern).toRealPath().getFileSystem().getPathMatcher("glob:" + pattern);
        Files.walk(Paths.get(".."))
                .filter(matcher::matches)
                .forEach(System.out::println);
    }
}