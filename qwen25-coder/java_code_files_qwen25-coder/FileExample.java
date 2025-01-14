import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        try {
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}