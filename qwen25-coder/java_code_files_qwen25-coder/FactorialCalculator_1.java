import java.lang.String;
public class FactorialCalculator_1 {
    // Java
    public int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }
    public static void main(String[] args) {
    }
}