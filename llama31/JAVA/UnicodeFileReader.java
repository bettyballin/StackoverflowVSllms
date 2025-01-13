import java.lang.String;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class UnicodeFileReader {
    public static void main(String[] args) throws IOException {
        String filePath = "path/to/your/file.txt";
        Charset charset = Charset.forName("UTF-16");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}