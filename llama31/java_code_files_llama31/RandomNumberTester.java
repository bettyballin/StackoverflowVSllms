/*
 * Decompiled with CFR 0.152.
 */
public class RandomNumberTester {
    public static void main(String[] stringArray) {
        UniqueRandomGenerator uniqueRandomGenerator = new UniqueRandomGenerator((long)Math.pow(2.0, 1024.0) + 1L, 48271L, 1L, System.currentTimeMillis());
        for (int i = 0; i < 10; ++i) {
            System.out.println(uniqueRandomGenerator.nextLong());
        }
    }
}
