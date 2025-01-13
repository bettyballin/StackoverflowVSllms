public class Test_4 {
    public static void Test1() {
        Assert(TestCase1());
    }

    public static void Test2() {
        Assert(TestCase2());
    }

    public static void Test3() {
        Assert(TestCase3());
    }

    public static boolean TestCase1() {
        // your test case 1 implementation here
        return true;
    }

    public static boolean TestCase2() {
        // your test case 2 implementation here
        return true;
    }

    public static boolean TestCase3() {
        // your test case 3 implementation here
        return true;
    }

    public static void Assert(boolean condition) {
        if (!condition) {
            throw new AssertionError("Assertion failed");
        }
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
    }
}