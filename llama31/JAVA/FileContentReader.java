import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileContentReader {
    public String readFileContent(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void main(String[] args) {
    }
}