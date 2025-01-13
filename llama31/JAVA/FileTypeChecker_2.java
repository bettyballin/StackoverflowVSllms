import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTypeChecker_2 {

    public static void main(String[] args) {
        Path path = Paths.get("path/to/your/file");

        try {
            String contentType = Files.probeContentType(path);
            if (contentType != null) {
                if (contentType.startsWith("text/")) {
                    System.out.println("File is a text file");
                } else {
                    System.out.println("File is a binary file");
                }
            } else {
                System.out.println("File type could not be determined");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}