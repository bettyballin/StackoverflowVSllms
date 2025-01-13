/*
 * Decompiled with CFR 0.152.
 */
public class StringHashCalculator {
    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        int n = StringHashCalculator.calculateHash(string.toCharArray());
        System.out.println("Hash: " + n);
    }

    public static int calculateHash(char[] cArray) {
        int n = 0;
        int n2 = cArray.length;
        for (int i = 0; i < n2; ++i) {
            n = 31 * n + cArray[i];
        }
        return n;
    }
}
