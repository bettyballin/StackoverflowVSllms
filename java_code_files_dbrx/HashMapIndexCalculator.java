import java.util.HashMap;
import java.util.Map;

public class HashMapIndexCalculator {
    public static void main(String[] args) {
        Map<Key, Integer> map = new HashMap<>();
        // Initialize the map with some values to avoid division by zero
        map.put(new Key("Key1"), 1);
        map.put(new Key("Key2"), 2);

        Key k = new Key("Hello"); // Your object that uses hashCode() function.
        int index = (k.hashCode() & 0x7fffffff) % map.size(); // Here you can also change the size of Map if it is bigger than default sizes used in HashMap or HashTable (which are based on powers of 2.)
        System.out.println("Index: " + index);
    }
}

class Key {
    private String value;

    public Key(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        // Using the hash code of the string value
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // Override equals when you override hashCode
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Key key = (Key) obj;
        return value.equals(key.value);
    }
}