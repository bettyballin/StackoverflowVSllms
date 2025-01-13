import java.lang.String;

public class ResponseHandler {
    public void onResponseReceived(Request request, Response response) {
        if (200 == response.getStatusCode()) {
            // Parse the JSON response
            JSONValue json = JSONParser.parse(response.getText());
            JSONObject obj = json.isObject();
            String value = obj.get("key").isString().stringValue();

            // Update the contents of the div
            // DOM.getElementById("myDiv").setInnerHTML(value); // Commented out because DOM is not a valid Java class
        }
    }

    public static void main(String[] args) {
        // Create an instance of ResponseHandler to avoid compilation error
        ResponseHandler handler = new ResponseHandler();
    }
}