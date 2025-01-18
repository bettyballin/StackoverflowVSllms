import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class FileReader {

    private String readFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace(); // or any proper handling for your case, like logging etc.
        }
        return contentBuilder.toString().trim();  // trim() to remove extra whitespaces if not required.
    }

    public static void main(String[] args) {
        // Empty main method
    }

}