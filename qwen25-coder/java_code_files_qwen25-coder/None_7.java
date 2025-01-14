import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class None_7 {
    String utf8Content = readFileAsString("path/to/utf8file.txt", "UTF-8");
    String cp1252Content = readFileAsString("path/to/cp1252file.txt", "CP1252");

    public String readFileAsString(String filename, String encoding) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            return new String(bytes, encoding);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
    }
}