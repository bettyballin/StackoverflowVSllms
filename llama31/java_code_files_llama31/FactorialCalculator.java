/*
 * Decompiled with CFR 0.152.
 */
public class FactorialCalculator {
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * this.factorial(n - 1);
    }

    public static void main(String[] stringArray) {
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        System.out.println(factorialCalculator.factorial(5));
    }
}
