/*
 * Decompiled with CFR 0.152.
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class QueryStringEncoder {
    public String toQueryString(Map<?, ?> map) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            stringBuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8") + "=");
            stringBuilder.append(URLEncoder.encode((String)entry.getValue(), "UTF-8") + "&");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
