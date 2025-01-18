public class javaPropertyTest {
    static {
        assertTrue(System.getProperty("system.test.property") != null);
    }
    public static void main(String[] args) {
    }
    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Assertion failed");
        }
    }
}