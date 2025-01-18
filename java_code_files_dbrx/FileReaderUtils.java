import java.lang.String;
import java.lang.Integer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderUtils {
    private static int readSoleInteger(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return Integer.parseInt(br.readLine().trim());
        }
    }
    
    public static void main(String[] args) {
    }
}