public class LuhnValidator {
    public boolean isValidLuhn(String number) {
        int sum = 0;
        boolean alternate = false;

        // Loop through digits from right to left
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(number.charAt(i));

            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }

            sum += n;
            alternate = !alternate;
        }

        return (sum % 10 == 0);
    }

    public static void main(String[] args) {
    }
}