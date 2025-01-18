import java.lang.String;
import java.lang.Integer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class InputReader {
    private static int readSoleInteger(String path) throws IOException {
        String line = Files.readAllLines(Path.of(path)).get(0);
        return Integer.parseInt(line.trim());
    }
    public static void main(String[] args) {
    }
}