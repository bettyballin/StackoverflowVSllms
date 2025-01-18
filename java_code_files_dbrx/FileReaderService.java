import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileReaderService {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("inputFile.txt"), StandardCharsets.UTF_16)) { // Replace "inputFile.txt" with unicode file name
            String line;
            while ((line = reader.readLine()) != null) {
                // your code for handling the read line goes here
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}