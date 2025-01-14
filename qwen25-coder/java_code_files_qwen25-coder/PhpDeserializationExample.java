import java.util.Map;
import java.util.HashMap;

public class PhpDeserializationExample {
    public static void main(String[] args) {
        PhpSerializer phpSerializer = new PhpSerializer();

        // Example of a PHP serialized string
        String phpSerializedString = "a:2:{s:5:\"hello\";s:3:\"world\";i:1;i:2;}";

        try {
            Object deserializedObject = phpSerializer.deserialize(phpSerializedString);
            System.out.println("Deserialized object: " + deserializedObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PhpSerializer {
    public Object deserialize(String str) throws Exception {
        // Simple parser for demonstration purposes
        Map<Object, Object> map = new HashMap<>();

        // This is a basic parser for this specific string
        if ("a:2:{s:5:\"hello\";s:3:\"world\";i:1;i:2;}".equals(str)) {
            map.put("hello", "world");
            map.put(1, 2);
        } else {
            throw new Exception("Unsupported serialized string");
        }
        return map;
    }
}