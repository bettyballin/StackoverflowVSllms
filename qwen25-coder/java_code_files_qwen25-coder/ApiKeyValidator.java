import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.net.URL;
import java.net.MalformedURLException;

public class ApiKeyValidator {
    public boolean validateApiKeyAndReferer(String apiKey, String referer) {
        Map<String, List<String>> validDomains = new HashMap<>();
        // Map of API keys to their allowed domains
        validDomains.put("API_KEY_123", Arrays.asList("http://mydomain.com", "https://www.mydomain.com"));

        if (!validDomains.containsKey(apiKey)) {
            return false;
        }

        List<String> allowedDomains = validDomains.get(apiKey);

        String referrerDomain;
        try {
            URL url = new URL(referer);
            referrerDomain = url.getHost();
        } catch (MalformedURLException e) {
            return false; // Invalid referer
        }

        for (String domain : allowedDomains) {
            if (domain.endsWith(referrerDomain)) {
                return true;
            }
        }

        return false;
    }
  
    public static void main(String[] args) {
    }
}