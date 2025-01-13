/*
 * Decompiled with CFR 0.152.
 */
public class FibonacciCalculator {
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return this.fibonacci(n - 1) + this.fibonacci(n - 2);
    }

    public static void main(String[] stringArray) {
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        int n = fibonacciCalculator.fibonacci(10);
        System.out.println("Fibonacci(10) = " + n);
    }
}
