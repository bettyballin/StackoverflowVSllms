/*
 * Decompiled with CFR 0.152.
 */
public class CallInfoParser {
    public static void parseCallInfo(char[] cArray) {
        byte by = (byte)cArray[0];
        boolean bl = (by & 0x80) != 0;
        boolean bl2 = (by & 0x40) != 0;
        boolean bl3 = (by & 0x20) != 0;
        boolean bl4 = (by & 0x10) != 0;
    }

    public static void main(String[] stringArray) {
    }
}
