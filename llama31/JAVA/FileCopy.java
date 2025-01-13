import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopy {
    public static void main(String[] args) {
        String source = "path/to/source/file";
        String destination = "path/to/destination/file";

        try {
            Files.copy(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // Handle the exception
        }
    }
}