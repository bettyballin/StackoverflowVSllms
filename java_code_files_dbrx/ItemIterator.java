import org.json.JSONArray;
import org.json.JSONObject;

public class ItemIterator {
    static JSONArray itemArray = new JSONArray();

    static {
        for (int i = 0; i < itemArray.length(); i++) { // Loop over all items
            JSONObject obj = itemArray.getJSONArray(i).getJSONObject(i); // get i-th object in array
        }
    }

    public static void main(String[] args) {
    }
}