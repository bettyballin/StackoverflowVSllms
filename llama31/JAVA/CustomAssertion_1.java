import org.assertj.core.api.Assertions;

/**
 * Custom assertion class for array comparisons.
 */
public class CustomAssertion_1_1 {

    /**
     * Asserts that two arrays contain exactly the same elements, regardless of order.
     * @param actual the actual array
     * @param expected the expected array
     */
    public static void assertArrays(String[] actual, String[] expected) {
        Assertions.assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    public static void main(String[] args) {
        // Example usage
        String[] actual = {"apple", "banana", "cherry"};
        String[] expected = {"banana", "apple", "cherry"};
        assertArrays(actual, expected);
        System.out.println("Assertion passed.");
    }
}