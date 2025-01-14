import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileReader {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("path/to/file.txt")));
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}