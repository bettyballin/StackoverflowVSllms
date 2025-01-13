import java.util.HashMap;

public class HashMapCaster {
    public void myMethod(HashMap map) {
        HashMap<String, String> stringMap = (HashMap<String, String>) map;
        // ...
    }

    public static void main(String[] args) {
    }
}