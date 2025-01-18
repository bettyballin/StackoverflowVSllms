import java.util.HashMap;

public class ImmutableFunction {

    private HashMap<String, String> cache = new HashMap<>(); // or use LinkedHashMap for LRU behavior.

    public String computeStuff(int arg1, int arg2) {
        String key = Integer.toString(arg1);
        key += Integer.toString(arg2); // This assumes both args are integers; you might need to do differently.
        if (cache.containsKey(key)) { // check if result is cached for the pair (arg1, arg2)
            return cache.get(key);  // found: return result from cache
        } else {
            String result = heavyComputationFunctionForArgs(arg1, arg2); // not found: compute and store in the map for future use
            cache.put(key, result);
            return result;
        }
    }

    private String heavyComputationFunctionForArgs(int arg1, int arg2) {
        // Implement your heavy computation here
        return "ComputedValue";
    }

    public static void main(String[] args) {
        // You can test your computeStuff method here
        ImmutableFunction obj = new ImmutableFunction();
        String result = obj.computeStuff(5, 10);
        System.out.println("Result: " + result);
    }
}