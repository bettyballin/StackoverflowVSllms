import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_565 {
    public static String readFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFile("path_to_your_file.txt"));
    }
}