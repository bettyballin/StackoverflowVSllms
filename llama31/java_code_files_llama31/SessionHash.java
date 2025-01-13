/*
 * Decompiled with CFR 0.152.
 */
public class SessionHash {
    public static long generateHash(String string, long l, String string2) {
        long l2 = 0L;
        l2 ^= (long)(string.hashCode() << 32);
        l2 ^= l;
        l2 ^= (long)string2.hashCode() & 0xFFFFFFFFL;
        l2 = l2 << 13 & 0xFFFFFFFFFFFFFFFFL;
        return l2;
    }

    public static void main(String[] stringArray) {
    }
}
