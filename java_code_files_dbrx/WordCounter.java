import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class WordCounter {
    public static void main(String[] args) throws IOException {
        // Open the file for reading
        try (BufferedReader reader = new BufferedReader(new FileReader("filename.txt"))) {
            int totalWords = 0;
            String line;
            // Read lines from the input and count words
            while ((line = reader.readLine()) != null) {
                String[] wordList = line.split("\\s+");
                for (int i = 0; i < wordList.length; i++) {
                    if (!wordList[i].equals("")) totalWords++;
                }
            }
            System.out.println("Total words in the file: " + totalWords);
        } catch (IOException e) {
            // Handle exception here
        }
    }
}