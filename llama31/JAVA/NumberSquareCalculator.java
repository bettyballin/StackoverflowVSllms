import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class NumberSquareCalculator {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            squaredNumbers.add(number * number);
        }
        System.out.println(squaredNumbers);
    }
}