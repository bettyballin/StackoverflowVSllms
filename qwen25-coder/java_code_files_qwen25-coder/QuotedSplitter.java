import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuotedSplitter {
    public static void main(String[] args) {
        String input = "a,\"string, with\",various,\"values, and some\",quoted";
        List<String> result = splitIgnoreQuoted(input);
        
        System.out.println(result);
    }

    public static List<String> splitIgnoreQuoted(String input) {
        List<String> parts = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|([^,]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                // Add quoted part
                parts.add(matcher.group(1));
            } else if (matcher.group(2) != null) {
                // Add non-quoted part
                parts.add(matcher.group(2).trim());
            }
        }

        return parts;
    }
}