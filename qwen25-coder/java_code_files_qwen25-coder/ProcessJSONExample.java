// To compile this code, you need to have the org.json library in your classpath.
// You can download the library from https://github.com/stleary/JSON-java
// Compile the code with:
// javac -cp .;path_to_json_jar\json.jar ProcessJSONExample.java
// Run the code with:
// java -cp .;path_to_json_jar\json.jar ProcessJSONExample

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class ProcessJSONExample {

    public void processJSON(JSONObject messageJson) {
        // Ensure the JSONObject is not null
        if (messageJson == null) {
            System.out.println("Invalid JSON data");
            return;
        }

        // Extract the item array
        JSONArray itemsArray = messageJson.optJSONArray("item");
        if (itemsArray == null) {
            System.out.println("Item array not found in JSON");
            return;
        }

        // Iterate over each item in the array
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject itemObject = itemsArray.optJSONObject(i);

            if (itemObject != null) {
                String id = itemObject.optString("ID");
                String primary = itemObject.optString("Primary");
                String secondary = itemObject.optString("Secondary");
                String date = itemObject.optString("Date");
                String region = itemObject.optString("Region");

                // Use the extracted data as needed
                System.out.println("Item " + i + ": ID=" + id + ", Primary=" + primary +
                             ", Secondary=" + secondary + ", Date=" + date +
                             ", Region=" + region);
            } else {
                System.out.println("Invalid item format at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String jsonData = "{ \"item\": [ { \"ID\": \"1\", \"Primary\": \"Value1\", \"Secondary\": \"Value2\", \"Date\": \"2023-10-01\", \"Region\": \"US\" }, { \"ID\": \"2\", \"Primary\": \"Value3\", \"Secondary\": \"Value4\", \"Date\": \"2023-10-02\", \"Region\": \"EU\" } ] }";

        // Parse the JSON data
        try {
            JSONObject messageJson = new JSONObject(jsonData);
            ProcessJSONExample example = new ProcessJSONExample();
            example.processJSON(messageJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}