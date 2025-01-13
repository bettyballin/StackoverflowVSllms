/*
 * Decompiled with CFR 0.152.
 */
public class ByteArrayPrinter {
    public static void main(String[] stringArray) {
        byte[] byArray;
        for (byte by : byArray = new byte[]{1, 2, 3, 4}) {
            System.out.print(String.format("%02x ", by));
        }
    }
}
