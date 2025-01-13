/*
 * Decompiled with CFR 0.152.
 */
public class Main_630 {
    public static void main(String[] stringArray) {
        String string = "84.52.184.224";
        String[] stringArray2 = string.split("\\.");
        long l = 0L;
        for (int i = 0; i < 4; ++i) {
            int n = Integer.parseInt(stringArray2[i]);
            l |= (long)n << 24 - i * 8;
        }
        String string2 = Long.toHexString(l);
        System.out.println("IP Address: " + string);
        System.out.println("Long: " + l);
        System.out.println("Hex: " + string2);
    }
}
