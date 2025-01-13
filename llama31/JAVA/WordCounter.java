import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class WordCounter {
    public static int countWords(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    tokenizer.nextToken();
                    wordCount++;
                }
            }
            return wordCount;
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "example.txt"; // replace with your file
        int wordCount = countWords(filename);
        System.out.println("Total words: " + wordCount);
    }
}