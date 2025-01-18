import java.util.Map;
import java.util.LinkedHashMap;

public class MyClass_14 {
    class MyClass {
        private final static int SIZE_LIMIT = 1000;
        private Map<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>(SIZE_LIMIT + 1, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > SIZE_LIMIT;
            }
        };
    }

    public static void main(String[] args) {
    }
}