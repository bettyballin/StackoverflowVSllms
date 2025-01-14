import java.lang.String;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class ClearJavaCache {
    public static void main(String[] args) throws IOException {
        String tmpDir = System.getProperty("java.io.tmpdir");
        Path path = Paths.get(tmpDir, "jav_content_cache");
        if (Files.exists(path)) {
            Files.walk(path)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(f -> f.delete());
            System.out.println("Java cache cleared.");
        } else {
            System.out.println("Java cache directory not found.");
        }
    }
}