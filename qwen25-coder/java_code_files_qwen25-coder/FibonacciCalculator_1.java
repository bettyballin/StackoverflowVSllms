public class FibonacciCalculator_1 {
    public int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
    }
}