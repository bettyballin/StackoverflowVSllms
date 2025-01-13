import java.lang.String;

public class CurrencyChecker {
    public static void main(String[] args) {
        char c = '$'; // or any other character you want to check
        if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CURRENCY_SYMBOLS) {
            System.out.println(c + " is a currency symbol");
        } else {
            System.out.println(c + " is not a currency symbol");
        }
    }
}