/*
 * Decompiled with CFR 0.152.
 */
public class FloatToHexStringConverter {
    public static void main(String[] stringArray) {
        float f = -3.14f;
        String string = (f < 0.0f ? "-" : "") + String.format("%08x", Float.floatToRawIntBits(Math.abs(f)));
        System.out.println(string);
    }
}
