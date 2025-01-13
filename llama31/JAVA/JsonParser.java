import org.json.JSONObject;

public class JsonParser {
    public static void main(String[] args) {
        String json1 = "{\"key\":\"value\"}";
        String json2 = "{\"key2\":\"value2\"}";

        // Concatenate JSON objects
        String concatenated = json1 + json2;

        parseJson(concatenated);
    }

    public static void parseJson(String json) {
        StringBuilder currentObject = new StringBuilder();
        int depth = 0;
        for (char c : json.toCharArray()) {
            currentObject.append(c);
            if (c == '{') {
                depth++;
            } else if (c == '}') {
                depth--;
                if (depth == 0) {
                    // Parse the JSON object
                    JSONObject jsonObject = new JSONObject(currentObject.toString());
                    System.out.println(jsonObject);
                    currentObject.setLength(0);
                }
            }
        }
    }
}