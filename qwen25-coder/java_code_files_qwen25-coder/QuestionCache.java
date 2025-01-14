import java.util.LinkedHashMap;
import java.util.Map;

public class QuestionCache {
    private final LinkedHashMap<Integer, String> cache;
    private final int capacity;

    public QuestionCache(int capacity) {
        this.capacity = capacity;
        // AccessOrder set to true to maintain the order of access
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > QuestionCache.this.capacity;
            }
        };
    }

    public void put(int questionId, String question) {
        cache.put(questionId, question);
    }

    public String get(int questionId) {
        return cache.remove(questionId); // Remove the entry once accessed
    }

    public boolean containsKey(int questionId) {
        return cache.containsKey(questionId);
    }

    public static void main(String[] args) {
    }
}