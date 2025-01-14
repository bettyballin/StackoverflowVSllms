public class VBStringValidator {
    public static boolean isValidVBString(String input) {
        String regex = "^\"([^\"\\\\]|\\.)*\"$|^\"\"";
        return input.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidVBString("\"Hello\"")); // true
        System.out.println(isValidVBString("\"He\\\"llo\"")); // false, incorrect escape sequence in Java string literal
        System.out.println(isValidVBString("\"He\\\"llo\"")); // false, not a valid VB string
        System.out.println(isValidVBString("\"He\"\"llo\"")); // true, valid escaped quote
        System.out.println(isValidVBString("\"\"")); // true, empty string
    }
}