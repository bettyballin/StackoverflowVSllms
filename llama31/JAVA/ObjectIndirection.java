import java.lang.String;
import java.lang.Map;
import java.lang.HashMap;
import java.util.UUID; // Added missing import statement

public class ObjectIndirection {
    private Map<String, Object> objects = new HashMap<>();

    public String addObject(Object obj) {
        String id = UUID.randomUUID().toString();
        objects.put(id, obj);
        return id;
    }

    public Object getObject(String id) {
        return objects.get(id);
    }

    public void updateReference(String id, Object newObj) {
        objects.put(id, newObj);
    }

    public static void main(String[] args) {
        ObjectIndirection oi = new ObjectIndirection();
        String id = oi.addObject("Hello, World!");
        System.out.println(oi.getObject(id));
        oi.updateReference(id, "Updated object");
        System.out.println(oi.getObject(id));
    }
}