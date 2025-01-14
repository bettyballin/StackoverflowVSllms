import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static void appendToFile(String filePath, String content) throws IOException {
        Files.writeString(Paths.get(filePath), content, java.nio.file.StandardOpenOption.APPEND);
    }

    public static void main(String[] args) {
        try {
            appendToFile("example.txt", "This is a test.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}