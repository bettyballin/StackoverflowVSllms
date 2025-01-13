/*
 * Decompiled with CFR 0.152.
 */
public class HashGenerator {
    public int customHash(long l, long l2) {
        int n = (int)(l ^ l2 << 16 ^ l2 >>> 16);
        return n;
    }

    public static void main(String[] stringArray) {
        HashGenerator hashGenerator = new HashGenerator();
        long l = 12345L;
        long l2 = 67890L;
        int n = hashGenerator.customHash(l, l2);
        System.out.println("Custom Hash: " + n);
    }
}
