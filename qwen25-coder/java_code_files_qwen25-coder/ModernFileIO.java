import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ModernFileIO {
    // Modern File IO with try-with-resources
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("filename.txt"))) {
           String line;
           while ((line = reader.readLine()) != null) {
               System.out.println(line);
           }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}