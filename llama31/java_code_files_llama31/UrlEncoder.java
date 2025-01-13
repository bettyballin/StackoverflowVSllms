/*
 * Decompiled with CFR 0.152.
 */
public class UrlEncoder {
    public static String encodeByteArray(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%%%02X", by));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
