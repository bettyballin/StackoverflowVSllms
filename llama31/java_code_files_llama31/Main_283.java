/*
 * Decompiled with CFR 0.152.
 */
public class Main_283 {
    public static void main(String[] stringArray) {
        System.out.println(Main_283.bitsRequired(11));
    }

    public static int bitsRequired(int n) {
        if (n == 0) {
            return 1;
        }
        int n2 = 0;
        while (n > 0) {
            n >>= 1;
            ++n2;
        }
        return n2;
    }
}
