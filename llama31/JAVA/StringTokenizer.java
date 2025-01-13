import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StringTokenizer {
    public static String[] split(String input) {
        List<String> result = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        boolean inQuote = false;

        for (char c : input.toCharArray()) {
            if (c == '"') {
                inQuote = !inQuote;
            } else if (c == ',' && !inQuote) {
                result.add(currentToken.toString());
                currentToken.setLength(0);
            } else {
                currentToken.append(c);
            }
        }

        result.add(currentToken.toString());
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String input = "a,\"string, with\",various,\"values, and some\",quoted";
        String[] tokens = split(input);
        System.out.println(Arrays.toString(tokens));
    }
}