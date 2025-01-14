import java.lang.String;
public class InputFilter {
    // Regex pattern that matches word characters including those across different Unicode scripts.
    public static final String WORD_CHAR_PATTERN = "^[\\p{L}\\p{N}_]+$";

    public static boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }
        return input.matches(WORD_CHAR_PATTERN);
    }

    public static void main(String[] args) {
        String testInput1 = "张伟"; // Chinese
        String testInput2 = "Вася"; // Russian
        String testInput3 = "John_Doe123";
        String testInput4 = "<script>alert('XSS');</script>";

        System.out.println(isValidInput(testInput1)); // true
        System.out.println(isValidInput(testInput2)); // true
        System.out.println(isValidInput(testInput3)); // true
        System.out.println(isValidInput(testInput4)); // false
    }
}