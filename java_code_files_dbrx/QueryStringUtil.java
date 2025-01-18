import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

public class QueryStringUtil {
    public String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
        StringBuilder queryString = new StringBuilder();

        for (Map.Entry<?, ?> pair : data.entrySet()) {
            queryString.append( URLEncoder.encode((String) pair.getKey(), "UTF-8") )
                .append("=")
                // URL encode your values first to avoid any possible issues with special characters
                .append(URLEncoder.encode(pair.getValue().toString(), "UTF-8"))
                .append("&");
        }
        if (queryString.length() > 0) {
            queryString.setLength(queryString.length() - 1);
        }
        return queryString.toString();
    }
}