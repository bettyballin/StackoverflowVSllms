/*
 * Decompiled with CFR 0.152.
 */
public class Factorial {
    public static int calculate(int n) {
        int n2 = 1;
        for (int i = 2; i <= n; ++i) {
            n2 *= i;
        }
        return n2;
    }

    public static void main(String[] stringArray) {
    }
}
