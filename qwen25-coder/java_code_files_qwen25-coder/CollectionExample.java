import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class CollectionExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");  // duplicate allowed

        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple");  // duplicate not added

        System.out.println("List: " + list);
        System.out.println("Set: " + set);
    }
}