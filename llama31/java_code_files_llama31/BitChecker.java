/*
 * Decompiled with CFR 0.152.
 */
public class BitChecker {
    public static boolean IsBitTrue(int n, int n2) {
        return (n & 1 << n2 - 1) != 0;
    }

    public static void main(String[] stringArray) {
        System.out.println(BitChecker.IsBitTrue(10, 2));
    }
}
