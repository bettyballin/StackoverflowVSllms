import java.lang.String;

public class CurrencySymbolChecker {
    public static void main(String[] args) {
        String currencySymbols = "\\p{Sc}"; // Sc is the Unicode property for currency symbols
        char c = '$'; // or any other character you want to check
        if (String.valueOf(c).matches(currencySymbols)) {
            System.out.println(c + " is a currency symbol");
        } else {
            System.out.println(c + " is not a currency symbol");
        }
    }
}