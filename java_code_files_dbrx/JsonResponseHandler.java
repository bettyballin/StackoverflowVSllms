public class JsonResponseHandler {
    public void onResponseReceived(Request request, Response response) {
        String responseText = response.getText();
        try {
            JavaScriptObject jso = (JavaScriptObject) new JSONParser().parse(responseText);
            JSArray<JSONValue> jsonArr = (JSArray<JSONValue>) jso;
            for (int i = 0; i < jsonArr.length(); i++) {
                String item = ((JSONString) jsonArr.get(i)).stringValue();
                // do something with the string
            }
        } catch (Exception e) {
            Window.alert(responseText);
        }
    }

    public static void main(String[] args) {
    }
}

// Stub classes to make the code compile
class Request {
    // Define methods and properties as needed
}

class Response {
    public String getText() {
        return "";
    }
}

class JavaScriptObject {
    // Empty stub class
}

class JSONParser {
    public Object parse(String str) {
        return new JavaScriptObject();
    }
}

class JSArray<T> {
    public int length() {
        return 0;
    }

    public T get(int index) {
        return null;
    }
}

class JSONValue {
    // Empty stub class
}

class JSONString extends JSONValue {
    public String stringValue() {
        return "";
    }
}

class Window {
    public static void alert(String str) {
        System.out.println("Alert: " + str);
    }
}