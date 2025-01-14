public class FactorialCalculator_2 {
    public long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        FactorialCalculator_2 calculator = new FactorialCalculator_2();
        System.out.println(calculator.factorial(5)); // Output: 120
    }
}