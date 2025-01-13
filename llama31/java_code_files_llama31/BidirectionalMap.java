/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class BidirectionalMap {
    Map<String, Integer> keyToValue = new HashMap<String, Integer>();
    Map<Integer, String> valueToKey = new HashMap<Integer, String>();

    public BidirectionalMap() {
        this.keyToValue.put("one", 1);
        this.keyToValue.put("two", 2);
        this.valueToKey.put(1, "one");
        this.valueToKey.put(2, "two");
    }

    public static void main(String[] stringArray) {
        BidirectionalMap bidirectionalMap = new BidirectionalMap();
        Integer n = bidirectionalMap.keyToValue.get("one");
        System.out.println("Value for key 'one': " + n);
        String string = bidirectionalMap.valueToKey.get(2);
        System.out.println("Key for value 2: " + string);
    }
}
