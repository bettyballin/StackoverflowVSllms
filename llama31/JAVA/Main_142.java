import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_142_142 {
    public static void main(String[] args) {
        String input = "I have a long string that I need to parse into an array of strings that do not exceed 40 characters in length.";
        int maxLength = 40;
        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\G\\s*(.{1," + maxLength + "})(?=\\s|$)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            result.add(matcher.group(1).trim());
        }

        System.out.println(result);
    }
}