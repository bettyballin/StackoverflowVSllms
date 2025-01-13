import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class FileCopy_1_1 {
    public static void main(String[] args) {
        String source = "path/to/source/file";
        String destination = "path/to/destination/file";

        try {
            FileUtils.copyFile(new File(source), new File(destination));
        } catch (IOException e) {
            // Handle the exception
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}