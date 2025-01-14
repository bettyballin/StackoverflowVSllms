import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt"; // specify your file path here
        long lineCount = countLines(filePath);
        System.out.println("Total number of lines: " + lineCount);
    }

    public static long countLines(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            long count = 0;
            while ((br.readLine()) != null) {
                count++;
            }
            return count;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return -1; // Return -1 to indicate an error
        }
    }
}