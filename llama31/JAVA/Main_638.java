import java.lang.String;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Main_638 {
    public static String encodeURIParameterValue(String value) throws Exception {
        // First, URL decode the string to avoid double encoding
        String decodedValue = URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        
        // Then, URL encode the string
        String encodedValue = URLEncoder.encode(decodedValue, StandardCharsets.UTF_8.name())
                .replace("%20", "%2520") // double encode spaces
                .replace("%26", "%2526") // double encode ampersands
                .replace("%3D", "%253D"); // double encode equals
        
        // Finally, manually encode the colon, slash and question mark
        return encodedValue.replace(":", "%3A").replace("/", "%2F").replace("?", "%3F");
    }

    public static void main(String[] args) throws Exception {
        String input = "http://google.com/resource?key=value1 & value2";
        String output = encodeURIParameterValue(input);
        System.out.println(output);
    }
}