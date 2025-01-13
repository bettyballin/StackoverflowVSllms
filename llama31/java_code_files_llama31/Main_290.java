/*
 * Decompiled with CFR 0.152.
 */
public class Main_290 {
    public static void main(String[] stringArray) {
        byte[] byArray = new byte[]{1, 2, 3, 4, 5};
        String string = Main_290.bytesToHex(byArray);
        System.out.println(string);
    }

    public static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }
}
