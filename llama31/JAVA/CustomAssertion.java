public class CustomAssertion {
    public static void assertArrays(String[] actual, String[] expected) {
        if (actual.length != expected.length) {
            throw new AssertionError("Arrays are not the same length");
        }
        boolean[] found = new boolean[expected.length];
        for (String a : actual) {
            boolean matched = false;
            for (int i = 0; i < expected.length; i++) {
                if (a.equals(expected[i]) && !found[i]) {
                    found[i] = true;
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                throw new AssertionError("Element not found in the expected array");
            }
        }
    }

    public static void main(String[] args) {
        String[] actual = {"a", "b", "c"};
        String[] expected = {"c", "b", "a"};
        try {
            assertArrays(actual, expected);
            System.out.println("Assertion passed");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }
}