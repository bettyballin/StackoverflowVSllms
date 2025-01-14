import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileCopier_1 {
    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path target = Paths.get("target.txt");

        try {
            Files.copy(source, target);
        } catch (IOException e) {
            System.err.println("Error while copying file: " + e.getMessage());
        }
    }
}