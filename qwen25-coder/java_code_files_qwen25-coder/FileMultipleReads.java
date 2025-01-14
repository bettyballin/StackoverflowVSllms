import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileMultipleReads {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";

        // First pass through the file
        try (BufferedReader br1 = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br1.readLine()) != null) {
                System.out.println("First read: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Second pass through the file
        try (BufferedReader br2 = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br2.readLine()) != null) {
                System.out.println("Second read: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}