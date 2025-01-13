/*
 * Decompiled with CFR 0.152.
 */
public class UniqueRandomGeneratorTest {
    public static void main(String[] stringArray) {
        UniqueRandomGenerator uniqueRandomGenerator = new UniqueRandomGenerator(1001);
        for (int i = 0; i < 1001; ++i) {
            System.out.println(uniqueRandomGenerator.next());
        }
    }
}
