import java.util.HashMap;
import java.lang.String;

// Define the JSNIMethod annotation
@interface JSNIMethod {
}

// Define the JavaScriptObject class
class JavaScriptObject {
}

// Define the Js class with the cast method
class Js {
    public static <T> T cast(Object obj) {
        return (T) obj;
    }
}

public class is {
    @JSNIMethod
    public static JavaScriptObject createHashMap(){
       return Js.cast(new HashMap<>());
    }
    // This assumes that a GWT compatible version of the HashMap class is available.
    public static void main(String[] args) {
    }
}