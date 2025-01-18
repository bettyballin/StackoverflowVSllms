import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("clickArea1", 5); // value represents the number of clicks
        obj.put("clickArea2", 3);

        try (FileWriter file = new FileWriter("/path/to/file")) {
            file.write(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class JSONObject {
    private Map<String, Object> map = new HashMap<>();

    public JSONObject() {
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean first = true;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!first) {
                sb.append(',');
            }
            sb.append('"').append(entry.getKey()).append("\":");
            if (entry.getValue() instanceof String) {
                sb.append('"').append(entry.getValue()).append('"');
            } else {
                sb.append(entry.getValue());
            }
            first = false;
        }
        sb.append('}');
        return sb.toString();
    }
}