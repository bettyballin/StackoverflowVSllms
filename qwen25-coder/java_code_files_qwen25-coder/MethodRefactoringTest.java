import java.lang.String;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MethodRefactoringTest {

    // Original method
    private String originalMethod(String input) {
        // Old, complicated implementation
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
        }
        return result.toString();
    }

    // New method
    private String newMethod(String input) {
        // Simplified implementation
        return input.chars()
                   .mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase((char)c) : Character.toUpperCase((char)c))
                   .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                   .toString();
    }

    @Test
    public void testMethodsProduceSameResults() {
        String[] testData = {"Hello", "WORLD", "Java", "123"};

        for (String data : testData) {
            assertEquals(originalMethod(data), newMethod(data), "Mismatch found for input: " + data);
        }
    }

	public static void main(String[] args) {
	}
}