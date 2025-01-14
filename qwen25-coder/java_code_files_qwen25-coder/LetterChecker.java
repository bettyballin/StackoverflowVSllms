public class LetterChecker {

    public boolean isEnglishLetterOrDigit(char c) {
        return (c >= 'A' && c <= 'Z') || 
               (c >= 'a' && c <= 'z') || 
               (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        // Example usage:
        LetterChecker checker = new LetterChecker();
        char corruptedChar = 'Š';
        boolean isValid = checker.isEnglishLetterOrDigit(corruptedChar);
        System.out.println(isValid); // Should print false for 'Š'
    }
}