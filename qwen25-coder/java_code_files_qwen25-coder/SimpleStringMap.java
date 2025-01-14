import java.util.HashMap;
import java.util.Map;

public class SimpleStringMap {
    Map<Long, String> map = new HashMap<Long, String>();

    public SimpleStringMap() {
        map.put(1L, "One");
        map.put(2L, "Two");
        map.put(3L, "Three");
    }

    public static void main(String[] args) {
    }
}