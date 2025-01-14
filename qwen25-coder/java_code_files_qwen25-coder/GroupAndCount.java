import java.util.HashMap;
import java.util.Map;

public class GroupAndCount {
    public static void main(String[] args) {
        // Example 2D array
        String[][] items = {
            {"apple", "fruit"},
            {"banana", "fruit"},
            {"carrot", "vegetable"},
            {"date", "fruit"},
            {"eggplant", "vegetable"}
        };

        // HashMap to store the group and count
        Map<String, Integer> groupCountMap = new HashMap<>();

        // Grouping items and counting occurrences
        for (String[] item : items) {
            String key = item[1]; // Assuming the second element is the group key
            groupCountMap.put(key, groupCountMap.getOrDefault(key, 0) + 1);
        }

        // Outputting results
        for (Map.Entry<String, Integer> entry : groupCountMap.entrySet()) {
            System.out.println("Group: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}