import java.lang.String;
public class EscapeSingleQuote {
    public static void main(String[] args) {
        String input = "It's a test with 'single' quotes.";
        String safeInput = input.replace("'", "''");
        
        System.out.println("Original: " + input);
        System.out.println("Escaped: " + safeInput);
    }
}