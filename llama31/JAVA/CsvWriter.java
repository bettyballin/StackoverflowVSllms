import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CsvWriter {
    public static void main(String[] args) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fileName.csv"), 32768)) {
            // Use bufferedWriter here
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}