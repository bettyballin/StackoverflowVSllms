/*
 * Decompiled with CFR 0.152.
 */
public class StackExample {
    public static void main(String[] stringArray) {
        int n = 5;
        int n2 = 3;
        int n3 = StackExample.add(n, n2);
        System.out.println(n3);
    }

    public static int add(int n, int n2) {
        return n + n2;
    }
}
