import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONProcessor {
    public void processJSON(JSONObject jsonValue) {
        JSONObject jsonObject = jsonValue;
        JSONArray jsonArray = jsonObject.getJSONArray("item");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            String id = item.getString("ID");
            String primary = item.getString("Primary");
            String secondary = item.getString("Secondary");
            String date = item.getString("Date");
            String region = item.getString("Region");

            // Add your logic here to handle the parsed values
            System.out.println("ID: " + id + ", Primary: " + primary + ", Secondary: " + secondary + ", Date: " + date + ", Region: " + region);
        }
    }

    public static void main(String[] args) {
        JSONProcessor processor = new JSONProcessor();
        String jsonString = "{\"item\": [{\"ID\": \"1\", \"Primary\": \"Primary1\", \"Secondary\": \"Secondary1\", \"Date\": \"Date1\", \"Region\": \"Region1\"}, {\"ID\": \"2\", \"Primary\": \"Primary2\", \"Secondary\": \"Secondary2\", \"Date\": \"Date2\", \"Region\": \"Region2\"}]}";
        try {
            JSONObject jsonValue = new JSONObject(jsonString);
            processor.processJSON(jsonValue);
        } catch (JSONException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}