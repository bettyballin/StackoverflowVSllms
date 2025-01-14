import java.lang.String;
public class ExtractParentheses {
    public static String getSubstringInParentheses(String input) {
        // Regular expression to match text inside parentheses
        String regex = "\\((.*?)\\)";
        
        // Create a pattern object
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        // Match the input string against the pattern
        java.util.regex.Matcher matcher = pattern.matcher(input);
        
        // Check if there's a match and return the captured group
        if (matcher.find()) {
            return matcher.group(1);
        }
        
        // Return null or empty string if no match is found
        return "";
    }

    public static void main(String[] args) {
        String testString = "GREECE (+30)";
        String result = getSubstringInParentheses(testString);
        System.out.println(result);  // Output: +30
    }
}