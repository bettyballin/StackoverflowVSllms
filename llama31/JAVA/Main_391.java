import java.util.Hashtable;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main_391_391 {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("banana", "fruit");
        hashtable.put("apple", "fruit");
        hashtable.put("dog", "animal");

        Set<String> keys = hashtable.keySet();
        List<String> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            System.out.println(key);
        }
    }
}