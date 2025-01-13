import java.lang.String;
import java.util.Map;
import java.util.HashMap;

// Original object
class Pipe {}

// Proxy for Pipe with dynamic properties
public class Pipe_1_1Proxy extends Pipe {
    private Map<String, Object> dynamicProperties = new HashMap<>();

    public void addProperty(String name, Object value) {
        dynamicProperties.put(name, value);
    }

    public Object getProperty(String name) {
        return dynamicProperties.get(name);
    }

    public static void main(String[] args) {
    }
}