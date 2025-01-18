import java.util.Arrays;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Input: abc,bbc,
        String input = "abc,bcc,"; // CSV line ending with a comma

        // Split on commas and remove whitespace from each token.
        String[] tokens = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        // If the input line ended with a comma, then add an empty string to emulate null/empty value
        if (input.endsWith(",") && Arrays.stream(tokens).noneMatch("".equals)) {
            tokens = Arrays.copyOf(tokens, tokens.length + 1);
            tokens[tokens.length - 1] = ""; // Empty string to emulate null value at the end
        }
    }
}