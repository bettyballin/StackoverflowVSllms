import java.lang.String;
import java.net.URI;
import java.util.regex.Pattern;

public class WebAddressValidator {

    private static final String WEB_URL_REGEX = "^(https?://)?([a-zA-Z0-9\\-]+)\\.([a-zA-Z]{2,})(/[a-zA-Z0-9\\-._~:/?#[\\]@!$&'()*+,;=]*)?$";

    public static boolean isValidWebAddress(String urlString) {
        if (urlString == null || urlString.isEmpty()) {
            return false;
        }

        // Try parsing the URL using URI class
        try {
            new URI("http://" + urlString);
            return true;
        } catch (Exception e) {
            // If URI parsing fails, check with regex
            Pattern pattern = Pattern.compile(WEB_URL_REGEX);
            return pattern.matcher(urlString).matches();
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidWebAddress("http://www.google.com")); // true
        System.out.println(isValidWebAddress("www.vg.no"));             // true
        System.out.println(isValidWebAddress("tv2.no"));                // true
        System.out.println(isValidWebAddress("novalidurl"));            // false
    }
}