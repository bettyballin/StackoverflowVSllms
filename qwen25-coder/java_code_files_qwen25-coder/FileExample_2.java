import java.lang.String;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample_2 {
    public static void main(String[] args) {
        String filePath = "example.txt";
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            // Writing to the file
            fileWriter.write("Hello, world!");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}