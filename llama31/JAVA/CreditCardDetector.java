import java.lang.String;
public class CreditCardDetector {
    public static String detectCardType(String cardNumber) {
        // Remove any non-digit characters
        cardNumber = cardNumber.replaceAll("\\D", "");

        // Check for Visa
        if (cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)) {
            return "Visa";
        }
        // Check for Mastercard
        else if (cardNumber.startsWith("51") || cardNumber.startsWith("52") || cardNumber.startsWith("53") ||
                cardNumber.startsWith("54") || cardNumber.startsWith("55")) {
            return "Mastercard";
        }
        // Check for Amex
        else if (cardNumber.startsWith("34") || cardNumber.startsWith("37")) {
            return "American Express";
        }
        // Check for Discover
        else if (cardNumber.startsWith("6011") || cardNumber.startsWith("64")) {
            return "Discover";
        }
        // Check for Diners Club
        else if (cardNumber.startsWith("300") || cardNumber.startsWith("301") || cardNumber.startsWith("302") ||
                cardNumber.startsWith("303") || cardNumber.startsWith("304") || cardNumber.startsWith("305")) {
            return "Diners Club";
        }
        else {
            return "Unknown";
        }
    }

	public static void main(String[] args) {
	}
}