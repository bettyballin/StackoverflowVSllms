import java.util.List;
import java.util.ArrayList;

public class StringParser {
    public static void main(String[] args) {
        String longString = "This is a sample string that we need to split into parts without cutting words in between to ensure readability and proper formatting.";
        int maxLength = 40;
        
        String[] result = parseString(longString, maxLength);
        
        for (String part : result) {
            System.out.println(part);
        }
    }

    public static String[] parseString(String input, int maxLength) {
        List<String> parts = new ArrayList<>();
        int length = input.length();
    
        for (int i = 0; i < length; ) {
            int end = Math.min(i + maxLength, length);
            if (end < length && !Character.isWhitespace(input.charAt(end))) {
                while (end > i && !Character.isWhitespace(input.charAt(end))) {
                    end--;
                }
                if (end == i) {
                    end = Math.min(i + maxLength, length);
                }
            }
            parts.add(input.substring(i, end).trim());
            i = end;
        }
        
        return parts.toArray(new String[0]);
    }
}