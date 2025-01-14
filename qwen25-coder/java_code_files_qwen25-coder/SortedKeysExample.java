import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class SortedKeysExample {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("banana", "yellow");
        hashtable.put("apple", "red");
        hashtable.put("orange", "orange");

        // Create a TreeSet from the HashSet of keys to sort them
        Set<String> sortedKeys = new TreeSet<>(hashtable.keySet());

        // Iterate through the sorted keys
        for (String key : sortedKeys) {
            System.out.println(key + ": " + hashtable.get(key));
        }
    }
}