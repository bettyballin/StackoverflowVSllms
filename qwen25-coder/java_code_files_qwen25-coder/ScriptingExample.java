import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import javax.script.*;

public class ScriptingExample {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript"); // Example with JavaScript

        // Pass a simple Java HashMap to the script
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", 123);
        engine.put("data", map);

        // Execute a script that uses the passed map
        String script = "print('Value of key1: ' + data.key1);";
        engine.eval(script);

        // Retrieve results back to Java if needed
        Object result = engine.eval("data.key2;");
        System.out.println("Retrieved value from JS context: " + result);
    }
}