import java.util.*;

public class SentenceGenerator {
    private static Map<String, List<String>> wordMap = new HashMap<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        // Example sentence words array
        String[] words = {"the", "dog", "jumped", "over", "the", "wall.", 
                         "the", "cat", "fell", "off", "the", "house."};
        
        // Populate the map with keys and their following words as values
        for (int i = 0; i < words.length - 1; i++) {
            String key = words[i];
            String value = words[i + 1];
            
            if (!wordMap.containsKey(key)) {
                wordMap.put(key, new ArrayList<>());
            }
            wordMap.get(key).add(value);
        }

        // Generate a sentence
        StringBuilder sentence = new StringBuilder();
        String currentWord = words[random.nextInt(words.length)];
        for (int i = 0; i < 10; i++) { // Let's make a 10-word sentence
            sentence.append(currentWord).append(" ");
            if (!wordMap.containsKey(currentWord)) {
                break;
            }
            List<String> nextWords = wordMap.get(currentWord);
            currentWord = nextWords.get(random.nextInt(nextWords.size()));
        }

        System.out.println(sentence.toString());
    }
}