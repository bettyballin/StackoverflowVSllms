import java.util.Map;
import java.util.HashMap;

public class KeyReplacer_1_1 {
    public static void main(String[] args) {
        Map<String, String> values = new HashMap<>();
        values.put("CHANNEL_TYPE", "Foo");
        values.put("ADDRESS", "Bar");
        values.put("URI", "http://example.com");

        String template = "..."; // your template string
        String replaced = KeyReplacer_1.replaceKeys(template, values);
        System.out.println(replaced);
    }

    public static String replaceKeys(String template, Map<String, String> values) {
        for (Map.Entry<String, String> entry : values.entrySet()) {
            template = template.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return template;
    }
}