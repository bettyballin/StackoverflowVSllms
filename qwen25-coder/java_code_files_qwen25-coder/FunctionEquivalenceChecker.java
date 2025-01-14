import java.lang.String;
import java.lang.Integer;
// Example of a simple method to check if two lambda expressions produce the same output for a range of inputs
public class FunctionEquivalenceChecker {
    public static <T> boolean areFunctionsEquivalent(java.util.function.Function<T, T> f1, java.util.function.Function<T, T> f2, T[] testValues) {
        for (T value : testValues) {
            if (!f1.apply(value).equals(f2.apply(value))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        java.util.function.Function<Integer, Integer> square = x -> x * x;
        java.util.function.Function<Integer, Integer> anotherSquare = y -> y * y;

        Integer[] testValues = {1, 2, 3, 4, 5};
        boolean areEquivalent = areFunctionsEquivalent(square, anotherSquare, testValues);
        System.out.println("The functions are equivalent: " + areEquivalent);
    }
}