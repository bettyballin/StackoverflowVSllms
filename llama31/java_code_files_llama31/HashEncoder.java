/*
 * Decompiled with CFR 0.152.
 */
public class HashEncoder {
    byte[] sha1Bytes = new byte[]{-102, -127, 51, 60, 27, 22, -28, -88, 60, 16, -13, 5, 44, 21, -112, -86, -33, 94, 46, 32};
    String encodedString = HashEncoder.encodeByteArray(this.sha1Bytes);

    public static void main(String[] stringArray) {
        HashEncoder hashEncoder = new HashEncoder();
        System.out.println(hashEncoder.encodedString);
    }

    public static String encodeByteArray(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }
}
