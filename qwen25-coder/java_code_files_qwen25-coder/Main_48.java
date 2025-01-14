import java.io.BufferedReader;
import java.io.FileReader;
import java.io IOException;

public class Main {
    private static int readSoleInteger(String path) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String integerAsString = buffer.readLine().trim();
            return Integer.parseInt(integerAsString);
        }
    }
}