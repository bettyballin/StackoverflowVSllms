import java.lang.String;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineCounter {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.txt";
        try {
            long lineCount = Files.lines(Paths.get(filePath)).count();
            System.out.println("Total lines: " + lineCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}