import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Wrapper {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            Stream<String> lines = reader.lines();
            lines.parallel().forEach(line -> FormerMain.main(line));
        } catch (IOException e) {
            // Handle exception
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}