import java.util.HashSet;
import java.util.Set;

public class SetUtilorSetExample {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
        mySet.add("Hello");
        mySet.add("World");

        // Get the first element from the set
        String firstElement = mySet.iterator().next();
        System.out.println(firstElement);
    }
}