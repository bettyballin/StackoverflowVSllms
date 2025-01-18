public class CurrencyUtils {
    public boolean isCurrencySymbol(char ch) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(ch);
        return block == Character.UnicodeBlock.CURRENCY_SYMBOLS;
    }
    public static void main(String[] args) {
    }
}