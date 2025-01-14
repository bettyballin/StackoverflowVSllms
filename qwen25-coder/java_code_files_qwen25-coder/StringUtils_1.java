import java.util.ArrayList;
import java.util.List;

public class StringUtils_1 {
    public static String[] commaDelimitedListToStringArray(String str, String escapeChar) {
        List<String> result = new ArrayList<>();
        
        // Escape the escape character for use in a regex
        String escapedEscapeChar = "\\" + escapeChar.charAt(0);
        
        // Regular expression to match items separated by commas, ignoring escaped commas
        String[] parts = str.split("(?<!" + escapedEscapeChar + ")\\,", -1);

        for (String part : parts) {
            // Replace escaped commas with plain commas in each part
            result.add(part.replaceAll(escapedEscapeChar + ",", ","));
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array = commaDelimitedListToStringArray("test,test\\,test\\,test,test", "\\");
        for (String s : array) {
            System.out.println(s);
        }
    }
}