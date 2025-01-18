import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class InputReaderUtils {

    public static void main(String[] args) {
        // Main method can be used for testing if needed
    }

    public static String readPayload(HttpServletRequest request) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                result.append(line);
            }
            // `result` holds the payload as a string.
            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading input stream", e);
        }
    }
}