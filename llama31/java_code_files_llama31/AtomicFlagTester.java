/*
 * Decompiled with CFR 0.152.
 */
public class AtomicFlagTester {
    public static void main(String[] stringArray) {
        AtomicFlagTester atomicFlagTester = new AtomicFlagTester();
        atomicFlagTester.testAndSetFlag();
    }

    public void testAndSetFlag() {
        TestAndSet testAndSet = new TestAndSet();
        if (testAndSet.testAndSet()) {
            System.out.println("Successfully set!");
        } else {
            System.out.println("Already set!");
        }
    }
}
