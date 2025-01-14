import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class RollingHashSearcher {
    public int hashBasedSearch(String pattern, String text) {
        Map<Integer, List<Integer>> hashTable = new HashMap<>();
        int pLength = pattern.length();
        int textLength = text.length();

        // Hash first window of pattern length in text
        int currentHash = 0;
        for (int i = 0; i < pLength - 1; i++) {
            currentHash = (currentHash * 31 + text.charAt(i)) % 1009; // Simple hash function example
        }

        // Slide the window over text
        for (int i = 0; i <= textLength - pLength; i++) {
            if (i > 0) {
                currentHash = (currentHash * 31 + text.charAt(i + pLength - 1) - text.charAt(i - 1) * (int) Math.pow(31, pLength - 1)) % 1009;
            }
            hashTable.computeIfAbsent(currentHash, k -> new ArrayList<>()).add(i);
        }

        // Compute pattern's hash
        int patternHash = 0;
        for (char c : pattern.toCharArray()) {
            patternHash = (patternHash * 31 + c) % 1009;
        }

        // Find matches in the table with same hash and verify substring match
        if (hashTable.containsKey(patternHash)) {
            for (int index : hashTable.get(patternHash)) {
                if (text.substring(index, index + pLength).equals(pattern)) {
                    return index; // Found a valid match
                }
            }
        }

        return -1; // No match found
    }

    public static void main(String[] args) {
    }
}