import java.lang.String;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UriEncoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "http://google.com/resource?key=value1 & value2";
        String encodedOutput = URLEncoder.encode(input, "UTF-8")
                                        .replace("+", "%20") // Replace + with %20
                                        .replace("%3A", ":")   // Replace %3A with :
                                        .replace("%2F", "/");  // Replace %2F with /

        // Manually percent-encode the rest of the special characters as per RFC 2396
        encodedOutput = encodedOutput.replace("&", "%26");
        System.out.println(encodedOutput);
    }
}