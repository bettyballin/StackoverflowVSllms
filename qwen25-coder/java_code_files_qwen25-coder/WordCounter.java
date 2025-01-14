import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total number of words: " + wordCount);
    }
}