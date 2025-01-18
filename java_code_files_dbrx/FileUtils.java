import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileUtils {
    private static String readFileAsString(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)
        );
        try {
            int cp;
            while ((cp = br.read()) != -1) {
                sb.append((char) cp);
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    }
}