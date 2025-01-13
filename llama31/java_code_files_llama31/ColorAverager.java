/*
 * Decompiled with CFR 0.152.
 */
public class ColorAverager {
    public static int averageColors(int ... nArray) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (int n5 : nArray) {
            n += n5 >> 24 & 0xFF;
            n2 += n5 >> 16 & 0xFF;
            n3 += n5 >> 8 & 0xFF;
            n4 += n5 & 0xFF;
        }
        return (n /= nArray.length) << 24 | (n2 /= nArray.length) << 16 | (n3 /= nArray.length) << 8 | (n4 /= nArray.length);
    }

    public static void main(String[] stringArray) {
        int n = -16776961;
        int n2 = -16711936;
        int n3 = -16776961;
        int n4 = ColorAverager.averageColors(n, n2, n3);
        System.out.println("Average color: " + Integer.toHexString(n4));
    }
}
