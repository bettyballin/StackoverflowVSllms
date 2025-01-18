import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONProcessor {
    public void processJSON(String jsonData) {
        JSONValue jsonValue = JSONParser.parseLenient(jsonData); // Use lenient parse as per your case
        if ((jsonValue.isArray() == null) && (jsonValue.isObject() == null))
            throw new RuntimeException("JSON data must be wrapped in an array or object");
        JSONArray array = jsonValue.isArray();
        if (array != null) {
            for (int i = 0, size = array.size(); i < size; i++) { // Loop over all items
                JSONObject item = array.get(i).isObject(); // get i-th item as a Json Object
                String id = item.get("ID").isString().stringValue(); // Get ID in item
            }
        }
    }
    public static void main(String[] args) {
    }
}

class JSONParser {
    public static JSONValue parseLenient(String jsonData) {
        // For simplicity, return a new JSONValue that represents an array
        return new JSONValue(new JSONArray());
    }
}

class JSONValue {
    private JSONArray arrayValue;
    private JSONObject objectValue;
    private JSONString stringValue;

    public JSONValue() {
        // default constructor
    }

    public JSONValue(JSONArray array) {
        this.arrayValue = array;
    }

    public JSONValue(JSONObject object) {
        this.objectValue = object;
    }

    public JSONValue(JSONString string) {
        this.stringValue = string;
    }

    public JSONArray isArray() {
        return arrayValue;
    }

    public JSONObject isObject() {
        return objectValue;
    }

    public JSONString isString() {
        return stringValue;
    }

    public JSONValue get(int index) {
        if (arrayValue != null) {
            return arrayValue.get(index);
        }
        return null;
    }
}

class JSONArray {
    private List<JSONValue> values;

    public JSONArray() {
        values = new ArrayList<>();
        // For simplicity, add a sample JSONValue
        values.add(new JSONValue(new JSONObject()));
    }

    public int size() {
        return values.size();
    }

    public JSONValue get(int index) {
        return values.get(index);
    }
}

class JSONObject {
    private Map<String, JSONValue> map;

    public JSONObject() {
        map = new HashMap<>();
        // For simplicity, add a sample key-value pair
        map.put("ID", new JSONValue(new JSONString("sample_id")));
    }

    public JSONValue get(String key) {
        return map.get(key);
    }
}

class JSONString extends JSONValue {
    private String value;

    public JSONString(String value) {
        this.value = value;
    }

    public String stringValue() {
        return value;
    }

    public JSONString isString() {
        return this;
    }
}