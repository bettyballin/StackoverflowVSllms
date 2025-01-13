import java.lang.String;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ResponseProcessor {
    public void onResponseReceived(String request, String response) {
        String responseText = response;
        try {
            JSONValue jsonValue = JSONValue.parse(responseText);
            JSONArray jsonArray = (JSONArray) jsonValue;
            if (jsonArray != null) {
                // process the array
                for (int i = 0; i < jsonArray.size(); i++) {
                    String value = (String) jsonArray.get(i);
                    // do something with the value
                }
            } else {
                // handle error
            }
        } catch (Exception e) {
            System.out.println(responseText);
        }
    }

    public static void main(String[] args) {
        ResponseProcessor rp = new ResponseProcessor();
        rp.onResponseReceived("", "");
    }
}