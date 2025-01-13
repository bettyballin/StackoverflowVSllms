import java.util.HashMap;
import java.util.Map;

public class GroupBy {
    public static void main(String[] args) {
        String[][] array = {
            {"Group1", "Item1"},
            {"Group1", "Item2"},
            {"Group2", "Item3"},
            {"Group2", "Item4"},
            {"Group2", "Item5"},
            {"Group3", "Item6"}
        };

        Map<String, Integer> groupCounts = new HashMap<>();

        for (String[] row : array) {
            String group = row[0];
            groupCounts.put(group, groupCounts.getOrDefault(group, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : groupCounts.entrySet()) {
            System.out.println("Group: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}