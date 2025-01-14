import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TextSearch {
    private HashMap<String, List<Integer>> index;

    public TextSearch(String[] words) {
        index = new HashMap<>();
        for (int pos = 0; pos < words.length; pos++) {
            String word = words[pos];
            if (!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
            }
            index.get(word).add(pos);
        }
    }

    public List<Integer> searchWord(String word) {
        return index.containsKey(word) ? index.get(word) : Collections.<Integer>emptyList();
    }

    public static void main(String[] args) {
        String text = "this is a sample text with several words this is for testing the search functionality";
        TextSearch searcher = new TextSearch(text.split("\\s+"));
        System.out.println("Positions of word 'is': " + searcher.searchWord("is"));
        System.out.println("Positions of word 'search': " + searcher.searchWord("search"));
    }
}