import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Main_568 {
    public static String readFile(String file) throws IOException {
        return Files.readString(Paths.get(file), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFile("example.txt"));
    }
}