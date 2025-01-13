import org.apache.commons.text.StringEscapeUtils;

public class SanitizerExample {
    public static void main(String[] args) {
        // Simulating user input for demonstration purposes
        String userInput = "<script>alert('XSS')</script>";
        
        // Sanitizing the input
        String sanitizedInput = StringEscapeUtils.escapeHtml4(userInput);
        
        // Printing the sanitized input
        System.out.println("Original Input: " + userInput);
        System.out.println("Sanitized Input: " + sanitizedInput);
    }
}