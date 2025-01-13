import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) throws IOException {
        File file = new File("path/to/file");
        FileInputStream fis = new FileInputStream(file);
        // Read from the file
        fis.read();
        // Close the file
        fis.close();
    }
}