import java.io.IOException;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import java.nio.file.*;

public class FileWithWildcard {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/path"); // your relative directory here
        WildcardFileFilter fileFilter = new WildcardFileFilter("*.txt");
        Files.walk(path)
             .filter(p -> fileFilter.accept(p.toFile()))
             .forEach(pathToFile -> {
                 System.out.println("Found match: " + pathToFile);
             });
    }
}