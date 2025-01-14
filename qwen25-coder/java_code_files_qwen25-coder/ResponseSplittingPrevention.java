import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ResponseSplittingPrevention {
    public static void main(String[] args) {
        String userInput = "someInput\r\nAnotherHeader: Value";
        
        try {
            // Use URLEncoder to escape user input
            String safeUserInput = URLEncoder.encode(userInput, "UTF-8");
            
            // Construct the header safely
            System.out.println("Set-Cookie: User=" + safeUserInput);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}