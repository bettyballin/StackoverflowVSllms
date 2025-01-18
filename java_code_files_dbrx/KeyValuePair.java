import java.util.*;

class KeyValuePair<KeyType, ValueType> {
    public KeyType key;
    public List<ValueType> values = new ArrayList<>(); // Stores multiple Values

    public KeyValuePair(KeyType k) { this.key = k; }
    public void add_value (ValueType v){  this.values.add(v);}
    @Override
    public String toString() {
        return "Key : " + key + ", Values: [ "+ values+ " ]";
    }
}

public class TupleTest{
     public static void main (String[] args) throws Exception {
        KeyValuePair<String, Integer> pair = new KeyValuePair<>("One");  // Creating a tuple-like object. Here key is of type String and Value is of Type Int
        pair.add_value(1); // Adding first value in our Pair object
        pair.add_value (2); // Adding second value to the same pair object

        System.out.println("Tuple Data " + pair ); // Printing Tuple data
    }
}