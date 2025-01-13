import java.lang.String;

public class KanaValidatorTester {
    public static void main(String[] args) {
        KanaValidator validator = new KanaValidator();
        String userInput = "ã“ã‚“ã«ã”"; // hiragana input
        if (validator.isHiragana(userInput)) {
            System.out.println("Valid hiragana input");
        } else {
            System.out.println("Invalid input");
        }
    }
}

class KanaValidator {
    public boolean isHiragana(String input) {
        for (char c : input.toCharArray()) {
            if (!isHiraganaChar(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isHiraganaChar(char c) {
        // This is a basic implementation and may not cover all cases.
        // You may need to adjust this method to suit your specific requirements.
        return (c >= 0x3040 && c <= 0x309F); // Hiragana Unicode range
    }
}