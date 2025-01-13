/*
 * Decompiled with CFR 0.152.
 */
public class IPAddressExtractor {
    public static void main(String[] stringArray) {
        Object var1_1 = null;
        String string = var1_1.getHeader("X-Forwarded-For");
        if (string != null) {
            System.out.println(string);
        }
    }
}
