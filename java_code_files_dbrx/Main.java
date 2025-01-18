import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // Using Java 8 lambda function
        List<Integer> filtered = new ArrayList<>(list);
        Predicate<? super Integer> predicate = i -> i > 2;
        filtered.removeIf(predicate.negate());

        System.out.println("Filtered list: " + filtered); // prints [3, 4]
    }
}