import java.io.FileInputStream;
import java.io.IOException;

public class FileReader_3_3 {
    public static void main(String[] args) {
        String file = "path_to_your_file"; // replace with your file path
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            // ...
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Error closing file input stream: " + e.getMessage());
                }
            }
        }
    }
}