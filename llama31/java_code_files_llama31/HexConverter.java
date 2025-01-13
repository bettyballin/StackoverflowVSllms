/*
 * Decompiled with CFR 0.152.
 */
public class HexConverter {
    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x ", by));
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] stringArray) {
    }
}
