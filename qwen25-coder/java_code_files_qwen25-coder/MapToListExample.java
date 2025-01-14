import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class MapToListExample {
    public static void main(String[] args) {
        // Example map
        Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3);

        // Convert the values of the map to a list
        List<Integer> list = new ArrayList<>(map.values());

        // Print the list
        System.out.println(list);
    }
}