import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HighFrequencyWords {
    public static void main(String[] args) throws IOException {
        String filePath = "path_to_your_text_file.txt";
        int topN = 10; // Find top 10 high frequency words

        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase(); // Normalize words to lowercase
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Use a PriorityQueue to find top N high frequency words
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        pq.addAll(wordFrequency.entrySet());

        for (int i = 0; i < topN; i++) {
            Map.Entry<String, Integer> entry = pq.poll();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}