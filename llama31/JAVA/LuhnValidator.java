import java.lang.String;

public class LuhnValidator {
    public boolean validateLuhn(String number) {
        int sum = 0;
        boolean alternate = false;
        for (int i = number.length() - 2; i >= 0; i--) { // start from second-to-last digit
            int digit = Character.getNumericValue(number.charAt(i));
            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        int checkDigit = Character.getNumericValue(number.charAt(number.length() - 1));
        return (sum * 9) % 10 == checkDigit;
    }

    public static void main(String[] args) {
        LuhnValidator validator = new LuhnValidator();
        System.out.println(validator.validateLuhn("79927398713")); // Example usage
    }
}