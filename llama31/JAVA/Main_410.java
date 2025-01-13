import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualLinkedHashBidiMap;

public class Main_410 {
    public static void main(String[] args) {
        BidiMap<String, Integer> bidiMap = new DualLinkedHashBidiMap<>();

        bidiMap.put("one", 1);
        bidiMap.put("two", 2);

        // Get value by key
        System.out.println(bidiMap.get("one")); // prints 1

        // Get key by value
        System.out.println(bidiMap.getKey(2)); // prints "two"
    }
}