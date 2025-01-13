import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("/path/to/file");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] contents = new byte[(int) file.length()];
            fis.read(contents);
            System.out.println(new String(contents));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}