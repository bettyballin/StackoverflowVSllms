import com.google.common.collect.HashBiMap;

public class Test_13 {
    public static void main(String[] args) {
        // Create an instance of BiMap
        HashBiMap<Integer, String> biMap = HashBiMap.create();

        // Add elements to the map
        biMap.put(10, "Gaurav");  // Puts key value pair in the map
        biMap.put(20, "Rohan");   // Puts another key and values into the map

        System.out.println("Initial Mappings are: ");
        for (Integer i : biMap.keySet()) {
            System.out.println("K - V : " + i + "  " + biMap.get(i));
        }

        // Access elements of the map using key
        System.out.println("Value at 10 is: " + biMap.get(10));

        // Find Key corresponding to a value
        Integer in = biMap.inverse().get("Rohan");
        if (in != null) {
            System.out.println("Key corresponding to 'Rohan' is: " + in);
        } else {
            System.out.println("No key found.");
        }
    }
}