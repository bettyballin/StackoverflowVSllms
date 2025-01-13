/*
 * Decompiled with CFR 0.152.
 */
public class OrderNumberObfuscator {
    public static void main(String[] stringArray) {
        long l = 12345L;
        long l2 = OrderNumberObfuscator.obfuscate(l);
        System.out.println("Obfuscated: " + l2);
        long l3 = OrderNumberObfuscator.deobfuscate(l2);
        System.out.println("Deobfuscated: " + l3);
    }

    public static long obfuscate(long l) {
        return l ^ 0x12345678L;
    }

    public static long deobfuscate(long l) {
        return l ^ 0x12345678L;
    }
}
