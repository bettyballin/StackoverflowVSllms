import java.lang.String;
// Secure file handling example
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SecureFileHandling {
    public static void main(String[] args) {
        // Use absolute file path and validate file existence
        File file = new File("/path/to/file.txt");
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            // Read file contents
            byte[] contents = new byte[(int) file.length()];
            fis.read(contents);
            System.out.println(new String(contents));
        } catch (IOException e) {
            // Handle file errors and exceptions
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}