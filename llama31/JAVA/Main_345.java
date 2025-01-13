import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Main_345 {
    public static void main(String[] args) {
        // Create a Multimap
        Multimap<String, String> wordMap = ArrayListMultimap.create();

        // Add values to the Multimap
        wordMap.put("the", "dog");
        wordMap.put("the", "wall");
        wordMap.put("the", "cat");
        wordMap.put("the", "house");
        wordMap.put("over", "the");

        // Get all values for a key
        Collection<String> values = wordMap.get("the");
        System.out.println(values); // [dog, wall, cat, house]

        // Get a random value for a key
        List<String> valueList = new ArrayList<>(wordMap.get("the"));
        String randomValue = valueList.get(new Random().nextInt(valueList.size()));
        System.out.println(randomValue); // e.g. "cat"
    }
}