import java.lang.String;

public class FibonacciCalculator {
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // NOT tail-recursive
        }
    }

    public static void main(String[] args) {
        FibonacciCalculator calculator = new FibonacciCalculator();
        int result = calculator.fibonacci(10); // Example usage
        System.out.println("Fibonacci(10) = " + result);
    }
}