import java.text.Normalizer;

public class Main_20 {
    public static String sanitize(String input) {
        // trim() removes whitespace from the beginning and end of the string
        input = input.trim();
        
        // Normalizer.normalize() decomposes Unicode characters into their base form
        // This helps prevent some types of Unicode-based attacks
        input = Normalizer.normalize(input, Normalizer.NFKC);
        
        // String.replace() is used to replace special characters with their HTML equivalent
        // This helps prevent XSS attacks
        input = input.replace("&", "&amp;")
                     .replace("<", "&lt;")
                     .replace(">", "&gt;")
                     .replace("\"", "&quot;")
                     .replace("'", "&#x27;");
        
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello, <b>World</b>!"));
    }
}