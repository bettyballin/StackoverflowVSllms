import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputSanitizer {

    // Method for validating user input (simple email check)
    public static boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method for encoding output to prevent XSS
    public static String encodeHtml(String input) {
        if (input == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch(c){
                case '<': builder.append("&lt;"); break;
                case '>': builder.append("&gt;"); break;
                case '&': builder.append("&amp;"); break;
                case '"': builder.append("&quot;"); break;
                case '\'': builder.append("&#39;"); break;
                default: builder.append(c);
            }
        }
        return  builder.toString();
    }

    public static void main(String[] args) {
        String userInput = "<script>alert('XSS');</script>";
        
        // Validate and sanitize input
        if (!validateEmail(userInput)) {
            System.out.println("Invalid email format");
        } else {
            System.out.println("Valid Email: " + userInput);
        }
        
        // Encode output for safe HTML display
        String safeHtmlOutput = encodeHtml(userInput);
        System.out.println("Safe Output: " + safeHtmlOutput);
    }
}