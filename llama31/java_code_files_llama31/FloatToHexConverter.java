/*
 * Decompiled with CFR 0.152.
 */
public class FloatToHexConverter {
    public static void main(String[] stringArray) {
        float f = 1.0f;
        String string = String.format("%08x", Float.floatToRawIntBits(f));
        System.out.println(string);
    }
}
