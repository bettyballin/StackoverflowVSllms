import java.util.*;

public class Main_166 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // Creating a List (ArrayList in this case, but you can choose any implementation like LinkedList, etc.)
        Set<String> set = new HashSet<>();   // Creating a Set. Note that I'm using HashSet here, which means ordering isn't guaranteed unlike TreeSet or LinkedHashSet

        list.add("Element1");
        list.add("Element2");
        list.add("Element1"); // Adding duplicated element in the List is allowed

        set.add("ElementA");
        set.add("ElementB");
        set.add("ElementA");  // Trying to add a duplicate 'ElementA' here, but it will not be inserted since Set doesn't allow duplicates
    }
}