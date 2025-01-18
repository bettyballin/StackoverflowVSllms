import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class RemoveDuplicatesFromListHelper {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // Add elements to the list
        list.add("apple");
        list.add("banana");
        list.add("apple"); // duplicate

        // Remove duplicates
        Set<String> tempSet = new HashSet<>(list);
        list.clear();
        list.addAll(tempSet);

        // Print the list after removing duplicates
        System.out.println(list);
    }
}