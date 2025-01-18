import java.util.Map;
import java.util.List;
import java.util.AbstractMap;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class GroupingResultValuesById {
    List<Result> resultList = new ArrayList<>();
    
    Map<Integer, List<String>> groupedResults = resultList
        .stream()
        .collect(Collectors.groupingBy(Result::getId)) // groups them by id
        .entrySet()
        .stream()
        .map(e -> new AbstractMap.SimpleImmutableEntry<>(
            e.getKey(), 
            e.getValue().stream().map(Result::getValue).collect(Collectors.toList())
        ))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue
        )); // groups values in the map by ids.

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

class Result {
    private int id;
    private String value;

    public Result(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}