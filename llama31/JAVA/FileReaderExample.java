import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader("yourfile.txt"))) {
            // read the file with bufferedReader1
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        try (BufferedReader bufferedReader2 = new BufferedReader(new FileReader("yourfile.txt"))) {
            // read the file again with bufferedReader2
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}