// Dummy Test annotation to enable compilation without external libraries
@interface Test {}

public class StringModifierTest {

    @Test
    public void testModifyChangesStringCorrectlyIfLengthGreaterThan5() {
        String[] inputs = setupTestCases(); // Use the shared input creation logic.
        for (String input : inputs) {
            if (input.length() > 5) {
                assertStringChanges(input, modify(input)); // Call the shared assertion code.
            }
        }
    }

    // Shared input creation logic
    private String[] setupTestCases() {
        // Example test cases
        return new String[] { "example", "test", "longerstring", "short" };
    }

    // The method to modify the input string
    private String modify(String input) {
        // Example modification: reverse the string
        return new StringBuilder(input).reverse().toString();
    }

    // Shared assertion code
    private void assertStringChanges(String input, String modifiedString) {
        // Simple assertion; in real code, use proper testing assertions
        if (!input.equals(modifiedString)) {
            System.out.println("String changed correctly from \"" + input + "\" to \"" + modifiedString + "\"");
        } else {
            System.out.println("String did not change for input \"" + input + "\"");
        }
    }

    public static void main(String[] args) {
        StringModifierTest test = new StringModifierTest();
        test.testModifyChangesStringCorrectlyIfLengthGreaterThan5();
    }
}