import java.util.regex.Pattern;

public class Main_21 {
    public static String sanitize(String input) {
        // Remove leading and trailing whitespace
        input = input.trim();
        
        // Remove HTML tags
        input = input.replaceAll("<.*?>", "");
        
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("<p>Hello, World!</p>"));
    }
}