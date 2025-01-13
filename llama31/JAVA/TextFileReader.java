import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class TextFileReader {
    public static void main(String[] args) {
        TextFileReader reader = new TextFileReader();
        reader.readFile();
    }

    public void readFile() {
        try (InputStream is = getClass().getResourceAsStream("path/to/your/textfile.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Process the line
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}