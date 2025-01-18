import java.lang.String;
public class TriStateParser {
    enum TriState { YES, NO, GREEN } // adjust names according to actual values/meanings

    static TriState fromChar(String value) throws IllegalArgumentException {
        for (TriState state : TriState.values()) { /* or use a hashmap if performance matters */
            if (state.name().charAt(0) == value.toUpperCase().charAt(0)) return state;
        }
        throw new IllegalArgumentException("Invalid char: " + value); // Or handle as per need
    }
    public static void main(String[] args) {
    }
}