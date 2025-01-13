import java.util.Map;

public class KeyReplacer {
    public static String replaceKeys(String template, Map<String, String> values) {
        StringBuilder sb = new StringBuilder(template.length());
        int start = 0;
        while (true) {
            int keyStart = template.indexOf('@', start);
            if (keyStart == -1) {
                break;
            }
            int keyEnd = template.indexOf('@', keyStart + 1);
            if (keyEnd == -1) {
                throw new RuntimeException("Unbalanced key in template");
            }
            String key = template.substring(keyStart + 1, keyEnd);
            String value = values.get(key);
            if (value == null) {
                throw new RuntimeException("Unknown key: " + key);
            }
            sb.append(template.substring(start, keyStart));
            sb.append(value);
            start = keyEnd + 1;
        }
        sb.append(template.substring(start));
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        String template = "Hello, @name@!";
        Map<String, String> values = Map.of("name", "John");
        System.out.println(replaceKeys(template, values));
    }
}