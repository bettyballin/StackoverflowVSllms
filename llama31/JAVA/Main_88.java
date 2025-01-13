import java.util.*;

public class Main_88_88 {
    public static void main(String[] args) {
        // Set
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // duplicate, will not be added
        System.out.println(set); // [Apple, Banana]

        // List
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple"); // duplicate, will be added
        System.out.println(list); // [Apple, Banana, Apple]
    }
}