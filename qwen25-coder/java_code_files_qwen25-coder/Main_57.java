import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Hashtable;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Mock request object
        MockRequest request = new MockRequest();

        // Sample data for "categoryDetails" attribute
        Hashtable<String, Hashtable<String, Integer>> categoryDetails = new Hashtable<>();

        // Populate categoryDetails with sample data
        Hashtable<String, Integer> subCategory1 = new Hashtable<>();
        subCategory1.put("sub2", 2);
        subCategory1.put("sub1", 1);

        Hashtable<String, Integer> subCategory2 = new Hashtable<>();
        subCategory2.put("sub3", 3);

        categoryDetails.put("categoryB", subCategory2);
        categoryDetails.put("categoryA", subCategory1);

        // Set the attribute in the request
        request.setAttribute("categoryDetails", categoryDetails);

        // ...

        @SuppressWarnings("unchecked")
        Hashtable<String, Hashtable<String, Integer>> cat = (Hashtable<String, Hashtable<String, Integer>>) request.getAttribute("categoryDetails");
        Map<String, Map<String, Integer>> sortedCat = new LinkedHashMap<>();

        for (String fun : new TreeSet<>(cat.keySet())) {
            Hashtable<String, Integer> subFunction = cat.get(fun);
            Map<String, Integer> sortedSubFunctions = new TreeMap<>(subFunction); // TreeMap sorts the keys
            sortedCat.put(fun, sortedSubFunctions);
        }

        request.setAttribute("categoryDetails", sortedCat);

        // Optional: Print the sorted categoryDetails to verify the result
        System.out.println("Sorted categoryDetails: " + request.getAttribute("categoryDetails"));
    }
}

// MockRequest class to simulate request object
class MockRequest {
    private Map<String, Object> attributes = new HashMap<>();

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }
}