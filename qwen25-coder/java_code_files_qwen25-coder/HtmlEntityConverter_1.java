import java.util.HashMap;
import java.util.Map;

public class HtmlEntityConverter_1 {

    public static void main(String[] args) {
        String s = "Happy &amp; Sad";
        System.out.println(s);
        
        s = convertHtmlEntities(s);
        System.out.println(s);  // Output: Happy & Sad
    }

    private static final Map<String, String> HTML_ENTITIES;

    static {
        HTML_ENTITIES = new HashMap<>();
        HTML_ENTITIES.put("&amp;", "&");
        HTML_ENTITIES.put("&lt;", "<");
        HTML_ENTITIES.put("&gt;", ">");
        HTML_ENTITIES.put("&quot;", "\"");
        HTML_ENTITIES.put("&#39;", "'");  // Note: This is for the apostrophe in HTML5
    }

    public static String convertHtmlEntities(String s) {
        for (Map.Entry<String, String> entity : HTML_ENTITIES.entrySet()) {
            s = s.replace(entity.getKey(), entity.getValue());
        }
        return s;
    }
}