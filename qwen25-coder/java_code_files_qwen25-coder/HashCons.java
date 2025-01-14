import java.util.HashMap;

public class HashCons {
    private HashMap<String, String> map = new HashMap<>();

    public String intern(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        } else {
            map.put(s, s);
            return s;
        }
    }

    public static void main(String[] args) {
        HashCons hc = new HashCons();
        String x = hc.intern("hello");
        String y = hc.intern("world");
        String z = hc.intern("hello");

        System.out.println(x == z); // true, because they are the same reference
    }
}