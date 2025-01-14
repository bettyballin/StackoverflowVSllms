import java.util.HashMap;
import java.util.Map;

public class RepeatedCharacters {
    public static void main(String[] args) {
        String test1 = "ABCDE";
        String test2 = "AABCD";

        System.out.println(findRepeats(test1)); // Output: No repeats
        System.out.println(findRepeats(test2)); // Output: A: 2
    }

    public static String findRepeats(String str) {
        if (str == null || str.isEmpty()) {
            return "No repeats";
        }

        Map<Character, Integer> charCount = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        boolean hasRepeats = false;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                hasRepeats = true;
                result.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
        }

        return hasRepeats ? result.toString().substring(0, result.length() - 2) : "No repeats";
    }
}