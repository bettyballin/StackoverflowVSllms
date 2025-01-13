import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader_1_1 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader1 = Files.newBufferedReader(Paths.get("yourfile.txt"))) {
            // read the file with bufferedReader1
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader2 = Files.newBufferedReader(Paths.get("yourfile.txt"))) {
            // read the file again with bufferedReader2
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}