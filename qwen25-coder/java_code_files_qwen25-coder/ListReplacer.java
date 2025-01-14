import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListReplacer {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        String target = "banana";
        String replacement = "orange";

        // Use ListIterator for efficient replacements
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals(target)) {
                iterator.set(replacement);
            }
        }

        System.out.println(list);  // Output: [apple, orange, cherry]
    }
}