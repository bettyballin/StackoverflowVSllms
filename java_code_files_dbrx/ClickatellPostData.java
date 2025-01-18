import java.util.HashMap;
import java.util.Map;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ClickatellPostData {
    private static final String YOUR_CLICKATELL_API = "your_api_key_here";

    Map<String, String> postData = new HashMap<>();

    {
        postData.put("apiKey", YOUR_CLICKATELL_API);
        postData.put("from", "your_sender");
        postData.put("content", URLEncoder.encode("שלום", StandardCharsets.UTF_8)); // Replace with your message content in Unicode Hebrew characters.
        postData.put("to", "<PHONE NUMBER>");
    }

    public static void main(String[] args) {
    }
}