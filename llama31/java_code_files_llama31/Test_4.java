/*
 * Decompiled with CFR 0.152.
 */
public class Test_4 {
    public static void Test1() {
        Test_4.Assert(Test_4.TestCase1());
    }

    public static void Test2() {
        Test_4.Assert(Test_4.TestCase2());
    }

    public static void Test3() {
        Test_4.Assert(Test_4.TestCase3());
    }

    public static boolean TestCase1() {
        return true;
    }

    public static boolean TestCase2() {
        return true;
    }

    public static boolean TestCase3() {
        return true;
    }

    public static void Assert(boolean bl) {
        if (!bl) {
            throw new AssertionError((Object)"Assertion failed");
        }
    }

    public static void main(String[] stringArray) {
        Test_4.Test1();
        Test_4.Test2();
        Test_4.Test3();
    }
}
