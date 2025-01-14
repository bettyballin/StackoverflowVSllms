import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class QueryStringUtils {
    public static String toQueryString(Map<String, String> data) throws UnsupportedEncodingException {
        StringBuilder queryString = new StringBuilder();

        for (Map.Entry<String, String> pair : data.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null) {
                continue; // Skip any entries with null keys or values
            }
            queryString.append(URLEncoder.encode(pair.getKey(), StandardCharsets.UTF_8.toString()));
            queryString.append("=");
            queryString.append(URLEncoder.encode(pair.getValue(), StandardCharsets.UTF_8.toString()));
            queryString.append("&");
        }

        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1); // Remove the trailing '&'
        }

        return queryString.toString();
    }
}