/*
 * Decompiled with CFR 0.152.
 */
public class CustomHash {
    public static int hashCode(String string) {
        int n = 0;
        for (char c : string.toCharArray()) {
            n = n * 37 + c ^ n >>> 16;
        }
        return n;
    }

    public static void main(String[] stringArray) {
    }
}
