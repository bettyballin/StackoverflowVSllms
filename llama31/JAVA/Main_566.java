import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_566 {
    public static String readFile(String file) throws IOException {
        return Files.readString(Paths.get(file));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFile("path_to_your_file.txt"));
    }
}