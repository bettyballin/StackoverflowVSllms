import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.io.UnsupportedEncodingException;

public class QueryStringEncoder {
    public String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
        StringBuilder queryString = new StringBuilder();

        for (Entry<?, ?> pair : data.entrySet()) {
            queryString.append(URLEncoder.encode((String) pair.getKey(), "UTF-8") + "=");
            queryString.append(URLEncoder.encode((String) pair.getValue(), "UTF-8") + "&");
        }

        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }

        return queryString.toString();
    }

    public static void main(String[] args) {
    }
}