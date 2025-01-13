import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

public class SendHebrewSms {
    public static void main(String[] args) {
        String hebrewMessage = "שלום, זה ניסיון"; // Your Hebrew message
        try {
            String encodedMessage = URLEncoder.encode(hebrewMessage, "UTF-8");

            // Clickatell API request
            String apiRequest = "http://api.clickatell.com/http/sendmsg?api_id=YOUR_API_ID&user=YOUR_USERNAME&password=YOUR_PASSWORD&to=+972123456789&text=" + encodedMessage;

            // Send the request
            System.out.println(apiRequest);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding exception: " + e.getMessage());
        }
    }
}