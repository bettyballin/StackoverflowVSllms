import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader_4_4 {
    public static void main(String[] args) {
        String file = "example.txt"; // replace with your file name
        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println("File opened successfully.");
            // add your code here to read from the file
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}