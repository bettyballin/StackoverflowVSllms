import java.lang.String;
public class UniqueHashGenerator {

    private static final int MAX_LENGTH = 7;

    public static long generateUniqueHash(String symbol) {
        if (symbol == null || symbol.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Symbol is too long or invalid.");
        }

        long hash = 0;
        for (int i = 0; i < symbol.length(); i++) {
            char c = symbol.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                hash = (hash << 5) | (c - 'A');
            } else {
                throw new IllegalArgumentException("Invalid character in symbol.");
            }
        }
        return hash;
    }

    public static void main(String[] args) {
        String symbol = "AAPL";
        long hash = generateUniqueHash(symbol);
        System.out.println("Hash for symbol '" + symbol + "' is: " + hash);
    }
}