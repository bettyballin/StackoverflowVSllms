/*
 * Decompiled with CFR 0.152.
 */
import java.text.StringCharacterIterator;

public class UnicodeValidator {
    public boolean isValidInput(String string) {
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(string);
        char c = stringCharacterIterator.first();
        while (c != '\uffff') {
            char c2 = c;
            if (!Character.isLetterOrDigit((int)c2)) {
                return false;
            }
            c = stringCharacterIterator.next();
        }
        return true;
    }

    public static void main(String[] stringArray) {
        UnicodeValidator unicodeValidator = new UnicodeValidator();
        System.out.println(unicodeValidator.isValidInput("HelloWorld"));
        System.out.println(unicodeValidator.isValidInput("Hello World"));
    }
}
