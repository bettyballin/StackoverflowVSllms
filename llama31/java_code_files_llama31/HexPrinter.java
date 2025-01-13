/*
 * Decompiled with CFR 0.152.
 */
public class HexPrinter {
    public static void main(String[] stringArray) {
        int n = 36;
        for (int i = 1; i <= n; ++i) {
            System.out.printf("%02x\n", i);
        }
    }
}
