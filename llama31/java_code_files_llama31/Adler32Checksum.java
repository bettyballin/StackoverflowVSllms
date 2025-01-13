/*
 * Decompiled with CFR 0.152.
 */
public class Adler32Checksum {
    public static int adler32(byte[] byArray) {
        int n = 1;
        int n2 = 0;
        for (byte by : byArray) {
            n = (n + by) % 65521;
            n2 = (n2 + n) % 65521;
        }
        return (n2 << 16) + n;
    }

    public static void main(String[] stringArray) {
    }
}
