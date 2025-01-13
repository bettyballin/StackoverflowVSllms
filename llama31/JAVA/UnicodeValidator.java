import java.lang.String;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class UnicodeValidator {
    public boolean isValidInput(String input) {
        CharacterIterator ci = new StringCharacterIterator(input);
        for (char c = ci.first(); c != CharacterIterator.DONE; c = ci.next()) {
            int codePoint = c;
            if (!Character.isLetterOrDigit(codePoint)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UnicodeValidator validator = new UnicodeValidator();
        System.out.println(validator.isValidInput("HelloWorld"));  // true
        System.out.println(validator.isValidInput("Hello World")); // false
    }
}