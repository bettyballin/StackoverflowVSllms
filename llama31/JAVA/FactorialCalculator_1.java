import java.lang.String;

public class FactorialCalculator_1_1 {

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n; // NOT tail-recursive
        }
    }

    // Can be rewritten as:
    public int factorialTailRecursive(int n) {
        return factorialHelper(n, 1);
    }

    public int factorialHelper(int n, int acc) {
        if (n == 0) {
            return acc;
        } else {
            return factorialHelper(n - 1, acc * n); // Tail-recursive
        }
    }

    public static void main(String[] args) {
        FactorialCalculator_1 calculator = new FactorialCalculator_1();
        System.out.println(calculator.factorial(5)); // prints 120
        System.out.println(calculator.factorialTailRecursive(5)); // prints 120
    }
}