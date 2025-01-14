import java.lang.String;
public class CurrencyUtilorCharacterChecker {
    public boolean isCurrencySymbol(char c) {
        return Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CURRENCY_SYMBOLS;
    }
    public static void main(String[] args) {
    }
}