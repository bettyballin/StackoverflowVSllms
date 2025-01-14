import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Optional;

public class CalculatorHelper {
    // Good: direct and clear
    public int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    // Bad: convoluted with no additional benefit
    public int calculateSumWithComplexity(int[] arrayNumbers) {
        List<Integer> listNumbers = Arrays.stream(arrayNumbers).boxed().collect(Collectors.toList());
        Optional<Integer> optionalTotal = listNumbers.stream().reduce(Integer::sum);
        return optionalTotal.orElseThrow(() -> new IllegalArgumentException("Array must not be empty"));
    }

    public static void main(String[] args) {
    }
}