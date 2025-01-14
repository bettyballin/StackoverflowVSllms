import java.util.HashMap;

// Define a class to hold two values
class ValuePair {
    private String value1;
    private int value2;

    public ValuePair(String value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }
}

public class Main {
    public static void main(String[] args) {
        HashMap<String, ValuePair> map = new HashMap<String, ValuePair>();
        map.put("key1", new ValuePair("valueA", 123));

        // Accessing the values
        ValuePair pair = map.get("key1");
        System.out.println(pair.getValue1()); // prints "valueA"
        System.out.println(pair.getValue2()); // prints 123
    }
}