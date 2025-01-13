import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Test_15_15 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> even = filter(numbers, i -> i % 2 == 0);
        System.out.println(even);
    }

    public static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : numbers) {
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        return result;
    }
}