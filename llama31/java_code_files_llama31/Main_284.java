/*
 * Decompiled with CFR 0.152.
 */
public class Main_284 {
    public static void main(String[] stringArray) {
        System.out.println(Main_284.bitsRequired(11));
    }

    public static int bitsRequired(int n) {
        if (n == 0) {
            return 1;
        }
        return 32 - Integer.numberOfLeadingZeros(n);
    }
}
