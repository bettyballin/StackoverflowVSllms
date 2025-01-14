import java.lang.String;
import java.io.*;

public class UnicodeFileReader {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt"; // Replace with your file path

        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-16")) {

            BufferedReader reader = new BufferedReader(isr);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}