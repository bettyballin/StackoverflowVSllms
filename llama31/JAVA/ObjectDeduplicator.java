import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class ObjectDeduplicator {
    public static void main(String[] args) {
        // Example usage
        List<String> yourObjectList = new ArrayList<>();
        yourObjectList.add("apple");
        yourObjectList.add("banana");
        yourObjectList.add("apple");

        Set<String> uniqueSet = new HashSet<>(yourObjectList);
        List<String> distinctList = new ArrayList<>(uniqueSet);

        System.out.println(distinctList);
    }
}