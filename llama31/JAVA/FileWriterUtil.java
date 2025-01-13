import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterUtil {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("example.txt")) {
            // write to file
            fos.write("Hello, World!".getBytes());
        } catch (IOException e) {
            // handle exception
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}