import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Main_567 {
    public static String readFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        try {
            System.out.println(readFile("path_to_your_file.txt"));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}