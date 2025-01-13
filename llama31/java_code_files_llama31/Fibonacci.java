/*
 * Decompiled with CFR 0.152.
 */
public class Fibonacci {
    public static void main(String[] stringArray) {
        for (int i = 0; i <= 10; ++i) {
            System.out.println(Fibonacci.fibonacci(i));
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci.fibonacci(n - 1) + Fibonacci.fibonacci(n - 2);
    }
}
