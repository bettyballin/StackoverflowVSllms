import java.lang.String;
// Example of reading a simple custom format
import java.io.BufferedReader;
import java.io.FileReader;

public class CustomFormatExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("data.custom"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Process each line as per the custom format
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}