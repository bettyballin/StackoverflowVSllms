import java.lang.String;

public class FactorialCalculator {
    // Example of a recursive function that could benefit from TCO
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1); // Not a tail call, actually
        }
    }

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        System.out.println(calculator.factorial(5)); // Example usage
    }
}