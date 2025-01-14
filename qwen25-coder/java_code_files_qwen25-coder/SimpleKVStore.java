import java.lang.String;
import java.util.HashMap;

public class SimpleKVStore {
    private HashMap<String, String> storage = new HashMap<>();

    public void put(String key, String value) {
        storage.put(key, value);
    }

    public String get(String key) {
        return storage.get(key);
    }

    public static void main(String[] args) {
        SimpleKVStore db = new SimpleKVStore();
        db.put("name", "Alice");
        System.out.println(db.get("name")); // Output: Alice
    }
}