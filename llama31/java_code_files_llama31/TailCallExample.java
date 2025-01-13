/*
 * Decompiled with CFR 0.152.
 */
public class TailCallExample {
    public static void main(String[] stringArray) {
        System.out.println(TailCallExample.factorial(10));
    }

    public static int factorial(int n) {
        return TailCallExample.factorial(n, 1);
    }

    public static int factorial(int n, int n2) {
        if (n == 0) {
            return n2;
        }
        return TailCallExample.factorial(n - 1, n * n2);
    }
}
